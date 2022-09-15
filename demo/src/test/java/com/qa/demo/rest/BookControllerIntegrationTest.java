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
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.demo.persistence.domain.Book;
import com.qa.demo.persistence.repos.LibraryRepo;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // sets up the MockMVC object
//@Sql(scripts = { "classpath:marsupial-schema.sql",
//		"classpath:marsupial-data.sql" }, executionphase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class BookControllerIntegrationTest {

	@Autowired // inject the MockMVC object into this class
	private MockMvc mvc; // object for sending mock http requests

	@Autowired
	private ObjectMapper mapper;

    @Autowired
    private LibraryRepo repo;

    private Book testBook;
    private List <Book> testBookFilter;
    private List<Book> booksInDb = new ArrayList<>();
    private Book savedBook;

    @BeforeEach
	public void init() {
		List<Book> books = List.of(
				new Book(9781507663165L, "Persuasion","Jane Austen"),
				new Book(9780307279460L, "A Walk in the woods","Bill Bryson"));

		        booksInDb.addAll(repo.saveAll(books));
                testBook = new Book(9781507663165L, "Persuasion","Jane Austen");
                testBookFilter = List.of(new Book(9781507663165L, "Persuasion","Jane Austen"));
                savedBook = new Book(1L, 9781507663165L, "Persuasion","Jane Austen");

    }
	@Test
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
	void testGetAllBooks() throws Exception {
		String savedBookAsJSON = this.mapper
				.writeValueAsString(booksInDb);

		RequestBuilder request = get("/getAll/books");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(savedBookAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
	}

    @Test
    void GetBookByIsbn() throws Exception {
        String savedBookAsJSON = this.mapper
        .writeValueAsString(booksInDb);
        

        RequestBuilder request = get("/getByIsbn/book?isbn="+testBook.getIsbn());

        ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(savedBookAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);

        
    }

}

