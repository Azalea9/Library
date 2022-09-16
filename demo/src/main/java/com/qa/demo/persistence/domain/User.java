package com.qa.demo.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long libId;

    @NotNull
    @Size(min = 8, max = 20)
    private String username;

    @NotNull
    @Size(min = 8, max = 20)
    private String password;

    
    @Pattern(regexp = "^(.+)@(.+)$")
    private String email;

    @Max(5)
    private int numOfBooksAllowed = 5;
    @Max(5)
    private int numOfBooksOnLoan;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Loan.class)
    @JoinColumn(name = "lib_id")
    private List<Loan> loanslist;



    // Empty Construct
    public User(){
    }

    // Constructor to create a user

    public User(Long libId, String username, String password, String email, int numOfBooksAllowed, int setNumOfBooksOnLoan) {
        
        this.libId = libId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.numOfBooksAllowed = 5;
        this.numOfBooksOnLoan = 0;
    }

    public User(String username, String password, String email, int numOfBooksAllowed, int setNumOfBooksOnLoan) {
        
        this.username = username;
        this.password = password;
        this.email = email;
        this.numOfBooksAllowed = 5;
        this.numOfBooksOnLoan = 0;
    }

    // Getters and Setters for Users
    public Long getLibId() {
        return libId;
    }

    public void setLibId(Long libId) {
        this.libId = libId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumOfBooksAllowed() {
        return numOfBooksAllowed;
    }

    public void setNumOfBooksAllowed(int numOfBooksAllowed) {
        this.numOfBooksAllowed = numOfBooksAllowed;
    }

    public int getNumOfBooksOnLoan() {
        return numOfBooksOnLoan;
    }

    public void setNumOfBooksOnLoan(int numOfBooksOnLoan) {
        this.numOfBooksOnLoan = numOfBooksOnLoan;
    }
    

    
}