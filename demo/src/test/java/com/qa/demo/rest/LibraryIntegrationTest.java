package com.qa.demo.rest;

// import static org.assertj.core.api.Assertions.assertThat;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// //import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.test.context.jdbc.Sql;
// import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
// import org.springframework.test.web.servlet.MockMvc;


// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.qa.demo.persistence.domain.Book;

// @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
// @AutoConfigureMockMvc

//@Sql(scripts = {"Classpath:book-schema.sql","classpath:book-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

// @ActiveProfiles(profiles ="test")
    

// public class LibraryIntegrationTest {
//     @Autowired
//     private MockMvc mockMVC;
    
//     @Autowired
//     private ObjectMapper mapper;

//     private final Book TEST_BOOK = new Book(null, 9781507663165L, "Persuasion","Jane Austen");
//     private final Book TEST_SAVED_BOOK = new Book(1L, 9781507663165L, "Persuasion","Jane Austen");

    // @Test
    // public void testCreateBook() throws Exception {
    //     final String resultString = this.mockMVC
    //             .perform(post("/create/book")
    //             .contentType(MediaType.APPLICATION_JSON)
    //             .content(this.mapper.writeValueAsString(TEST_BOOK)))
    //             .andExpect(status().isCreated()).andReturn().getRequest().getContentAsString();


    //     Book result = this.mapper.readValue(resultString, Book.class);
    //     assertThat(result).isEqualTo(TEST_BOOK);

      
    // }
    // @Test
    // public void testGetBookbyIsbn() throws Exception {
    //     this.mockMVC.perform(get("/getByIsbn/book?isbn=9781507663165")).andExpect(status().isOk())
    //                 .andExpect(content().json(this.mapper.writeValueAsString(TEST_SAVED_BOOK)));
    
    //     }


    // @Test
    // public void testGetAllBooks() throws Exception {
    //     final List<Book> BOOKS = new ArrayList<>();
    //     BOOKS.add(TEST_SAVED_BOOK);

    //     final String resultString = 
    //         this.mockMVC
    //                 .perform(request(HttpMethod.GET, "/getAll/books")
    //                 .accept(MediaType.APPLICATION_JSON))
    //                 .andExpect(status().isOk())
    //                 .andReturn()
    //                 .getResponse()
    //                 .getContentAsString();

    //     List<Book> results = Arrays.asList(mapper.readValue(resultString, Book[].class));
    //     assertThat(results).contains(this.TEST_BOOK).hasSize(1);

    // }

    // @Test
    // public void testDeleteBook() throws Exception {
    //     this.mockMVC.perform(delete("/delete/book/1")).andExpect(status().isNoContent());
    //     }






    
//}
