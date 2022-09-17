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
import com.qa.demo.persistence.domain.User;
import com.qa.demo.persistence.repos.UserRepo;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // sets up the MockMVC object
//@Sql(scripts = { "classpath:book-schema.sql",
//		"classpath:book-data.sql" }, executionphase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerIntegrationTest {

	@Autowired // inject the MockMVC object into this class
	private MockMvc mvc; // object for sending mock http requests

	@Autowired
	private ObjectMapper mapper;

    @Autowired
    private UserRepo repo;

    private User testUser;
    private User testUserChanged;
    private List<User> usersInDb = new ArrayList<>();
    private User savedUser;

    @BeforeEach
	public void init() {
		List<User> users = List.of(
				new User("Freddy123", "P@55word", "Freddy123@mail.com", 5, 0),
				new User("Samguest", "P@55word", "Samguest@mail.com", 5, 0));

		        usersInDb.addAll(repo.saveAll(users));
                testUser = new User(1L,"Freddy123", "P@55word", "Freddy123@mail.com", 5, 0);
                testUserChanged = new User(1L,"Freddy123", "P@55word", "Frederic@mail.com", 5, 0);
                savedUser = new User(1L,"Freddy123", "P@55word", "Freddy123@mail.com", 5, 0);

    }


	@Test
	void testCreateUser() throws Exception {
		
		String testUserAsJSON = this.mapper.writeValueAsString(testUser);
        String savedUserAsJSON = this.mapper.writeValueAsString(savedUser);

		// method, path, headers, body
		RequestBuilder request = post("/create/user").contentType(MediaType.APPLICATION_JSON)
				.content(testUserAsJSON);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(savedUserAsJSON);
        
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
    }

    @Test
	@Order(1)
	void testGetAllUsers() throws Exception {
		String savedUsersAsJSON = this.mapper
				.writeValueAsString(usersInDb);

		RequestBuilder request = get("/getAll/users/");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(savedUsersAsJSON);

		this.mvc.perform(request).andExpect(checkStatus);
		
	}

    @Test
	@Order(2)
    void GetUserByLibId() throws Exception {
		usersInDb.add(repo.save(testUser));
        String savedBookAsJSON = this.mapper.writeValueAsString(testUser);
        
        RequestBuilder request = get("/getBylibID?libId="+testUser.getLibId());

        ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(savedBookAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);

    }

	@Test
	@Order(3)
	void testUpdateUser() throws Exception {
		usersInDb.add(repo.save(testUser));

		final String testUserAsJSON = this.mapper.writeValueAsString(testUserChanged);

		RequestBuilder request = put("/update/email?libId="+testUserChanged.getLibId()).contentType(MediaType.APPLICATION_JSON)
				.content(testUserAsJSON);
				

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(testUserAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
	}

	@Test
	@Order(4)
	void deleteById() throws Exception {

		final String testUserAsJSON = this.mapper.writeValueAsString(testUserChanged);
		RequestBuilder request = delete("/delete/user/"+testUserChanged.getLibId()).contentType(MediaType.APPLICATION_JSON)
		.content(testUserAsJSON);

		ResultMatcher checkStatus = status().isOk();
		
		this.mvc.perform(request).andExpect(checkStatus);
	}

}
