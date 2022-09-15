package com.qa.demo.services;


import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.qa.demo.exceptions.BookNotFoundException;

import com.qa.demo.persistence.domain.Book;
import com.qa.demo.persistence.repos.LibraryRepo;

@Service
public class BookService {


    private LibraryRepo repo;
    
    public BookService(LibraryRepo repo){
        super();
        this.repo = repo;
    }

    //Create a book
    public Book addBook(Book book){
       
        return this.repo.save(book);
    }

    //Get all books
    public List<Book> getAllBooks(){
        
        return this.repo.findAll();
    }

    //Get an individual book by ISBN 
    public Book getBookByIsbn(Long isbn){

        Book found = this.repo.findByIsbn(isbn);
        if (found == null){
            throw new BookNotFoundException("The book for "+isbn+ " is not found");
        }
        return this.repo.findByIsbn(isbn);
        
    }

    //Get a book by title
    public List<Book> findBookByTitle(String title){

        return this.repo.findByTitleContaining(title);
    }

    //Get a book by author
     public List<Book> findBookbyAuthor(String authors){
   
        return this.repo.findByAuthorsContaining(authors);
     }


    //Update - get a book and replace with book
    public Book updateBook(Long id, Book newBook){
        
        Optional<Book> existingOptional = this.repo.findById(id);
        Book existing = existingOptional.get();
        existing.setAuthors(newBook.getAuthors());
        existing.setIsbn(newBook.getIsbn());
        existing.setTitle(newBook.getTitle());
        return this.repo.save(existing);
    }

    // removes a book by id
    public boolean removeBook(Long id){
       
        if (!this.repo.existsById(id)){
            throw new BookNotFoundException("Book "+id + " is not found");
        }

        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;


    }

    
}