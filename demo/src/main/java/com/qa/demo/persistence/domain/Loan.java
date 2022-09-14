package com.qa.demo.persistence.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "loans")
public class Loan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @NotNull
    private Long bookId;

    @NotNull
    private Long libId;

    private LocalDate startDate;
    private LocalDate expiryDate;

    public Loan(Long loanId, Long bookId, Long libId, LocalDate startDate, LocalDate expiryDate) {
        super();
        // the books are set to return in 21 days
        LocalDate returnDate = LocalDate.now().plusDays(21);
        this.loanId = loanId;
        this.bookId = bookId;
        this.libId = libId;
        this.startDate = LocalDate.now();
        this.expiryDate = returnDate;
    }

    // Empty Construcor
     public Loan(){
        super();
    }


    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getLibId() {
        return libId;
    }

    public void setLibId(Long libId) {
        this.libId = libId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    
}
