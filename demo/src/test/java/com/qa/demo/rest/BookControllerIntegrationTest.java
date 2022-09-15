package com.qa.demo.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.demo.persistence.domain.Book;
import com.qa.demo.persistence.repos.LibraryRepo;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc 
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@Sql(scripts = { "classpath:book-schema.sql",
//		"classpath:book-data.sql" }, executionphase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class BookControllerIntegrationTest {

	@Autowired // inject the MockMVC object into this class
	private MockMvc mvc; // object for sending mock http requests

	@Autowired
	private ObjectMapper mapper;

    @Autowired
    private LibraryRepo repo;

    private Book testBook;
    private Book testBookChanged;
	private Book testAddBook;
    private List<Book> booksInDb = new ArrayList<>();
    private Book savedBook;

    @BeforeEach
	public void init() {
		List<Book> books = List.of(
				new Book(9781507663165L, "Persuasion","Jane Austen"),
				new Book(9780307279460L, "A Walk in the woods","Bill Bryson"));

		        booksInDb.addAll(repo.saveAll(books));
				testAddBook = new Book(3L,9798469518259L, "Black Beauty","Anna Sewell");
                testBook = new Book(1L,9781507663165L, "Persuasion","Jane Austen");
                testBookChanged = new Book(1L,9781507663165L, "Pride and Prejudice","Jane Austen");
                savedBook = new Book(1L, 9781507663165L, "Persuasion","Jane Austen");

    }
	@Test
	@Order(3)
	void testCreateBook() throws Exception {
		
		String testBookAsJSON = this.mapper.writeValueAsString(testBook);
        String savedBookAsJSON = this.mapper.writeValueAsString(savedBook);

		// method, path, headers, body
		RequestBuilder request = post("/create/book").contentType(MediaType.APPLICATION_JSON)
				.content(testBookAsJSON);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(savedBookAsJSON);
        
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
    }

    @Test
	@Order(1)
	void testGetAllBooks() throws Exception {
		String savedBookAsJSON = this.mapper
				.writeValueAsString(booksInDb);

		RequestBuilder request = get("/getAll/books");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(savedBookAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
	}

    @Test
	@Order(2)
    void GetBookByIsbn() throws Exception {
		booksInDb.add(repo.save(testAddBook));

		String addedBookAsJSON = this.mapper
				.writeValueAsString(testAddBook);


       // String savedBookAsJSON = this.mapper.writeValueAsString(testBook);
        
        RequestBuilder request = get("/getByIsbn/book?isbn="+testAddBook.getIsbn());

        ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(addedBookAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);

    }

	@Test
	@Order(4)
	void testUpdate() throws Exception {
		booksInDb.add(repo.save(testBook));

		final String testBookAsJSON = this.mapper.writeValueAsString(testBookChanged);

		RequestBuilder request = put("/update/book?id="+testBookChanged.getId()).contentType(MediaType.APPLICATION_JSON)
				.content(testBookAsJSON);
				

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(testBookAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
	}

	@Test
	@Order(5)
	void deleteById() throws Exception {

		final String testBookAsJSON = this.mapper.writeValueAsString(testBookChanged);
		RequestBuilder request = delete("/delete/book/"+testBookChanged.getId()).contentType(MediaType.APPLICATION_JSON)
		.content(testBookAsJSON);

		ResultMatcher checkStatus = status().isOk();
		
		this.mvc.perform(request).andExpect(checkStatus);
	}

}

