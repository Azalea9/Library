package com.qa.demo.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;




@Entity
@Table(name = "books")
public class Book {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @NotNull
    @Min(13)
    @Column(name = "isbn")
    private Long isbn;

   @NotNull
    private String title;

    @NotNull
    private String authors;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Loan.class)
    @JoinColumn(name = "book_Id")
    private List<Loan> loanslist;
  

    // Constructor to create a book
    public Book(Long id, Long isbn, String title, String authors) {
        super();
        this.bookId = id;
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
    }

    public Book(Long isbn, String title, String authors) {
        super();
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
    }

        // Empty Construcor
        public Book(){
            super();
        }

    // Getters and Setters for Book
    public Long getId() {
        return bookId;
    }

    public void setId(Long id) {
        this.bookId = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public Book orElseThrow(Object object) {
        return null;
    }
}
