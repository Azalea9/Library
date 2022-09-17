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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.annotation.Order;
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
//@Sql(scripts = { "classpath:book-schema.sql",
//		"classpath:book-data.sql" }, executionphase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookControllerIntegrationTest {

	@Autowired // inject the MockMVC object into this class
	private MockMvc mvc; // object for sending mock http requests

	@Autowired
	private ObjectMapper mapper;

    @Autowired
    private LibraryRepo repo;

    private Book testBook;
	private Long testBookIsbn;
	private Book bookUpdateInfo;
    private List<Book> booksInDb = new ArrayList<>();
  
	

    @BeforeEach
	public void init() {
		List<Book> books = List.of(
				new Book(9781507663165L, "Persuasion","Jane Austen"),
				new Book(9780307279460L, "A Walk in the woods","Bill Bryson"));

		        booksInDb.addAll(repo.saveAll(books));
				testBook = new Book(1L,9781507663190L, "Persuasion","Jane Austen");
				testBookIsbn = testBook.getIsbn();
                bookUpdateInfo = new Book(9781507663190L, "Persuasion and other stories","Jane Austen");
                

    }

	@Test
	@Order(1)
	void testGetAllBooks() throws Exception {
		String savedBooksAsJSON = this.mapper
				.writeValueAsString(booksInDb);

		RequestBuilder request = get("/getAll/books");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(savedBooksAsJSON);

		this.mvc.perform(request).andExpect(checkStatus);
		
	}

    @Test
	@Order(2)
    void GetBookByIsbn() throws Exception {
		booksInDb.add(repo.save(testBook));

		String addedBookAsJSON = this.mapper
				.writeValueAsString(testBook);
        
        RequestBuilder request = get("/getByIsbn/book?isbn="+testBookIsbn);

        ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(addedBookAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);

    }

	@Test
	@Order(3)
	void testCreateBook() throws Exception {
		// works if 3L
		Book expectedTestBook = new Book(testBook.getId(),testBook.getIsbn(), testBook.getTitle(), testBook.getAuthors());          
		
		String testBookAsJSON = this.mapper.writeValueAsString(testBook);
        String savedBookAsJSON = this.mapper.writeValueAsString(expectedTestBook);

		// method, path, headers, body
		RequestBuilder request = post("/create/book").contentType(MediaType.APPLICATION_JSON)
				.content(testBookAsJSON);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(savedBookAsJSON);
        
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
    }


	@Test
	@Order(4)
	void testUpdate() throws Exception {
		booksInDb.add(repo.save(bookUpdateInfo));

		final String testBookAsJSON = this.mapper.writeValueAsString(bookUpdateInfo);

		RequestBuilder request = put("/update/book?id="+bookUpdateInfo.getId()).contentType(MediaType.APPLICATION_JSON)
				.content(testBookAsJSON);
				

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(testBookAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
	}

	@Test
	@Order(5)
	void deleteById() throws Exception {

		final String testBookAsJSON = this.mapper.writeValueAsString(testBook);
		RequestBuilder request = delete("/delete/book/"+testBook.getId()).contentType(MediaType.APPLICATION_JSON)
		.content(testBookAsJSON);

		ResultMatcher checkStatus = status().isOk();
		
		this.mvc.perform(request).andExpect(checkStatus);
	}

}

