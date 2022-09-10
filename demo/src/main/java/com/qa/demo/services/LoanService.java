package com.qa.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.demo.persistence.domain.Loan;
import com.qa.demo.persistence.domain.User;
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
       
        return this.repo.save(loan);
    }

    //Get current loans for a Library user
    public List<Loan> getLoanByLibId(Long libId){
        
        return this.repo.findBylibId(libId);
    }

    //Update - when a book is returned the expiry date is updated to today
    public Loan returnLoan(Long id, Loan newLoan){
        
        Optional<Loan> existingOptional = this.repo.findById(id);
        Loan existing = existingOptional.get();
        existing.setExpiryDate(LocalDate.now());
        return this.repo.save(existing);

    }
}


