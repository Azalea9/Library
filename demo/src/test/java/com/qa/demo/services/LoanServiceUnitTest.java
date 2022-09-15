package com.qa.demo.services;

import java.util.List;
import java.util.Optional;
//import java.util.Optional;
import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.demo.persistence.domain.Loan;
import com.qa.demo.persistence.repos.LoanRepo;


@SpringBootTest
public class LoanServiceUnitTest {
    @Autowired
    private LoanService service;

    @MockBean
    private LoanRepo repo;

    @Test
    void testCreateLoan(){

        Loan newLoan = new Loan(null, 12L, 1020L, LocalDate.of(2022,9,13),LocalDate.of(2022,9,24));

        Loan createdLoan = new Loan(1L, 12L, 1020L, LocalDate.of(2022,9,13),LocalDate.of(2022,9,24));

        Mockito.when(this.repo.save(newLoan)).thenReturn(createdLoan);

        Assertions.assertThat(this.service.createLoan(newLoan)).isEqualTo(createdLoan);

    }

    @Test
    void testGetAllLoans(){
        final List<Loan> loans = List.of(new Loan(1L,24L, 1020L,LocalDate.of(2022,9,13),LocalDate.of(2022,9,24)),
                    new Loan(2L,65L, 1020L,LocalDate.of(2022,9,13),LocalDate.of(2022,9,24)));

        Mockito.when(this.repo.findAll()).thenReturn(loans);

        Assertions.assertThat(loans.size()).isGreaterThan(0);
    }

    @Test
    void testFindBylibId(){
        final Long libId = 1020L;
        final List<Loan> newLoan = List.of(new Loan(1L,34L, 1020L,LocalDate.of(2022,9,13),LocalDate.of(2022,9,24)));

        Mockito.when(this.repo.findBylibId(libId)).thenReturn(newLoan);
        Assertions.assertThat(this.service.findByLibId(libId)).isEqualTo(newLoan);
        Mockito.verify(this.repo, Mockito.times(1)).findBylibId(libId);
    }

    
//     @Test
//     void testReturnLoan(){
//         Long libId = 1020L;
        
//         final Loan loan = new Loan(1L,24L, 1020L, LocalDate.of(2022,10,22), LocalDate.of(2022,10,21));
//         Optional <Loan> optionalLoan = Optional.of(loan);

//         Loan updateLoan = new Loan(1L,24L, 1020L, LocalDate.of(2022,10,22), LocalDate.now());
        
//         Mockito.when(this.repo.findById(libId)).thenReturn(optionalLoan);
//         Mockito.when(this.repo.save(updateLoan)).thenReturn(updateLoan);

//         Assertions.assertThat(this.service.findByLibId(libId)).isEqualTo(updateLoan);


//    }   
}


