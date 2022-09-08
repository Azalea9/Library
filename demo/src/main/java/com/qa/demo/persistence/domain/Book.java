package com.qa.demo.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    // Empty Construcor
    public Book(){
    }

    // Constructor to create a book
    public Book(Long isbn, String title, String authors) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
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
}
