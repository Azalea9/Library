package com.qa.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.qa.demo.persistence.domain.Loan;
import com.qa.demo.persistence.repos.LoanRepo;


@Service
public class LoanService {
    
    private LoanRepo repo;

    public LoanService(LoanRepo repo){
        super();
        this.repo = repo;
    }

    //Create a loan
    public Loan createLoan(Loan loan){
        loan.setStartDate(LocalDate.now());
        loan.setExpiryDate(LocalDate.now().plusDays(21));
        return this.repo.save(loan);
    }

    //Get all loans
    public List<Loan> findAllLoans(){
        
        return this.repo.findAll();
    }

    // Get all loans for a library user
    public List<Loan> findByLibId(Long libId){
        return this.repo.findBylibId(libId);
    }


    //Update - when a book is returned the expiry date is updated to today
    public Loan returnLoan(Long loanId, Loan newLoan){
        
        Optional<Loan> existingOptional = this.repo.findById(loanId);
        Loan existing = existingOptional.get();
        existing.setExpiryDate(newLoan.getExpiryDate());
        existing.setBookId(newLoan.getBookId());
        existing.setLibId(newLoan.getLibId());
        existing.setStartDate(newLoan.getStartDate());
        return this.repo.save(existing);

    }
}


