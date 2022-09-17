// package com.qa.demo.rest;


// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;

// import javax.transaction.Transactional;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.MethodOrderer;
// import org.junit.jupiter.api.Order;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.TestMethodOrder;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.RequestBuilder;
// import org.springframework.test.web.servlet.ResultMatcher;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.qa.demo.persistence.domain.Book;
// import com.qa.demo.persistence.domain.Loan;
// import com.qa.demo.persistence.domain.User;
// import com.qa.demo.persistence.repos.LibraryRepo;
// import com.qa.demo.persistence.repos.LoanRepo;
// import com.qa.demo.persistence.repos.UserRepo;




// @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
// @AutoConfigureMockMvc // sets up the MockMVC object
// //@Sql(scripts = { "classpath:book-schema.sql",
// //		"classpath:book-data.sql" }, executionphase = ExecutionPhase.BEFORE_TEST_METHOD)
// @ActiveProfiles("test")
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// public class LoanControllerIntegrationTest {

// 	@Autowired // inject the MockMVC object into this class
// 	private MockMvc mvc; // object for sending mock http requests

// 	@Autowired
// 	private ObjectMapper mapper;

//     @Autowired
//     private LoanRepo repo;

// 	@Autowired
// 	private UserRepo userRepo;
	
// 	@Autowired
// 	private LibraryRepo libraryRepo;


//     private Loan testLoan;
//     private Loan testLoanChanged;
//     private List<Loan> loansInDb = new ArrayList<>();
//     private Loan savedLoan;
// 	private Book testBook1;
// 	private Book testBook2;
// 	private User testUser;


//     @BeforeEach
// 	public void init() {
// 		// Book data - need to support referential integrity of db
// 		testBook1 = new Book(3L,9798469518259L, "Black Beauty","Anna Sewell");
// 		testBook2 = new Book(4L, 9781507663165L, "Pride and Prejudice","Jane Austen");

// 		this.libraryRepo.save(testBook1);
// 		this.libraryRepo.save(testBook2);

// 		// User data - need to support referential integrity of db

// 		testUser = new User(1L,"Freddy123", "P@55word", "Freddy123@mail.com", 5, 0);

// 		this.userRepo.save(testUser);

// 		// Loan data
// 		List<Loan> loans =  List.of(
// 				new Loan(1L, 1L),
// 				new Loan(2L,1L));

// 		        loansInDb.addAll(repo.saveAll(loans));
//                 testLoan = new Loan(1L,1L,1L,LocalDate.now(),LocalDate.now().plusDays(21));
//                 testLoanChanged = new Loan(2L,2L, 1L,LocalDate.now(),LocalDate.of(2022, 10, 07));
//                 savedLoan = new Loan(1L,1L, 1L,LocalDate.now(),LocalDate.now().plusDays(21));


//     }
// 	@Test
// 	@Order(3)
// 	void testCreateLoan() throws Exception {
		
// 		String testLoanAsJSON = this.mapper.writeValueAsString(testLoan);
//         String savedLoanAsJSON = this.mapper.writeValueAsString(savedLoan);

// 		// method, path, headers, body
// 		RequestBuilder request = post("/create/loan").contentType(MediaType.APPLICATION_JSON)
// 				.content(testLoanAsJSON);

// 		ResultMatcher checkStatus = status().isOk();
// 		ResultMatcher checkContent = content().json(savedLoanAsJSON);
        
// 		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
//     }

//     @Test
// 	@Order(1)
// 	void testGetAllLoans() throws Exception {
// 		String savedLoansAsJSON = this.mapper
// 				.writeValueAsString(loansInDb);

// 		RequestBuilder request = get("/find/loans");

// 		ResultMatcher checkStatus = status().isOk();
// 		ResultMatcher checkContent = content().json(savedLoansAsJSON);

// 		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
// 	}

//     @Test
// 	@Order(2)
//     void GetLoansByLibId() throws Exception {
// 		loansInDb.add(repo.save(testLoan));
//         String savedLoanAsJSON = this.mapper.writeValueAsString(loansInDb);
        
//         RequestBuilder request = get("/find/loans/id?libId="+testLoan.getLibId());

//         ResultMatcher checkStatus = status().isOk();
// 		ResultMatcher checkContent = content().json(savedLoanAsJSON);

// 		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);

//     }

// 	@Test
// 	@Order(4)
// 	void testUpdateLoan() throws Exception {
// 		loansInDb.add(repo.save(testLoan));

// 		final String testLoanAsJSON = this.mapper.writeValueAsString(testLoanChanged);

// 		RequestBuilder request = put("/return/loan?loanId="+testLoanChanged.getLoanId()).contentType(MediaType.APPLICATION_JSON)
// 				.content(testLoanAsJSON);
				

// 		ResultMatcher checkStatus = status().isOk();
// 		ResultMatcher checkContent = content().json(testLoanAsJSON);

// 		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
// 	}



// }