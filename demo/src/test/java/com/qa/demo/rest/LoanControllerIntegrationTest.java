package com.qa.demo.rest;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
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
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.demo.persistence.domain.Loan;

import com.qa.demo.persistence.repos.LoanRepo;




@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // sets up the MockMVC object
//@Sql(scripts = { "classpath:book-schema.sql",
//		"classpath:book-data.sql" }, executionphase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class LoanControllerIntegrationTest {

	@Autowired // inject the MockMVC object into this class
	private MockMvc mvc; // object for sending mock http requests

	@Autowired
	private ObjectMapper mapper;

    @Autowired
    private LoanRepo repo;

    private Loan testLoan;
    private Loan testLoanChanged;
    private List<Loan> loansInDb = new ArrayList<>();
    private Loan savedLoan;

    @BeforeEach
	public void init() {
		List<Loan> loans =  List.of(
				new Loan(100L, 1234L),
				new Loan(130L,1234L));

		        loansInDb.addAll(repo.saveAll(loans));
                testLoan = new Loan(1L,100L, 1234L,LocalDate.now(),LocalDate.now().plusDays(21));
                testLoanChanged = new Loan(1L,100L, 1234L,LocalDate.now(),LocalDate.of(2022, 10, 22));
                savedLoan = new Loan(1L,100L, 1234L,LocalDate.now(),LocalDate.now().plusDays(21));

    }
	@Test
	void testCreateLoan() throws Exception {
		
		String testLoanAsJSON = this.mapper.writeValueAsString(testLoan);
        String savedLoanAsJSON = this.mapper.writeValueAsString(savedLoan);

		// method, path, headers, body
		RequestBuilder request = post("/create/loan").contentType(MediaType.APPLICATION_JSON)
				.content(testLoanAsJSON);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(savedLoanAsJSON);
        
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
    }

    @Test
	void testGetAllLoans() throws Exception {
		String savedLoansAsJSON = this.mapper
				.writeValueAsString(loansInDb);

		RequestBuilder request = get("/find/loans");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(savedLoansAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
	}

    // @Test
    // void GetLoansByLibId() throws Exception {
	// 	loansInDb.add(repo.save(testLoan));
    //     String savedLoanAsJSON = this.mapper.writeValueAsString(testLoan);
        
    //     RequestBuilder request = get("/find/loans/id?libId="+testLoan.getLibId());

    //     ResultMatcher checkStatus = status().isOk();
	// 	ResultMatcher checkContent = content().json(savedLoanAsJSON);

	// 	this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);

    // }

	@Test
	void testUpdateLoan() throws Exception {
		loansInDb.add(repo.save(testLoan));

		final String testLoanAsJSON = this.mapper.writeValueAsString(testLoanChanged);

		RequestBuilder request = put("/return/loan?loanId="+testLoanChanged.getLoanId()).contentType(MediaType.APPLICATION_JSON)
				.content(testLoanAsJSON);
				

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(testLoanAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
	}



}