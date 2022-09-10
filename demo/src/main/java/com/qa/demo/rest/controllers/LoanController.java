package com.qa.demo.rest.controllers;

import java.util.List;

import javax.websocket.server.PathParam;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.qa.demo.persistence.domain.Loan;
import com.qa.demo.services.LoanService;

@RestController
public class LoanController {
    private LoanService loanService;
 
    public LoanController(LoanService loanService){
        super();
        this.loanService = loanService;
      
    }

   //Create a new book loan
    @PostMapping("/create/loan")
    public Loan createLoan(@RequestBody Loan loan){
        return this.loanService.createLoan(loan);
    }

    // fetch back all loans
    @GetMapping("/find/loans")
    public List<Loan> getAllLoans(){
        return this.loanService.findAllLoans();
    }

    // fetch back all current loans for a library user.
    @GetMapping("/find/loans/id")
    public List<Loan> getLoansByLibId(@PathParam("libId") Long libId){
        return this.loanService.findByLibId(libId);
    }
    // update an existing book
    @PutMapping("/return/loan")
    public Loan returnLoan(@PathParam("loanId") Long loanId, @RequestBody Loan loan){
        return this.loanService.returnLoan(loanId, loan);
    }
}
