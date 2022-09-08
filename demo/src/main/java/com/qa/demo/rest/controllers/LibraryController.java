package com.qa.demo.rest.controllers;

import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.persistence.domain.Book;
import com.qa.demo.services.BookService;



@RestController
public class LibraryController {

    private BookService bookService;
 

    public LibraryController(BookService bookService){
        super();
        this.bookService = bookService;
      
    }

    // get all books
    @GetMapping("/getAll/books")
    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    // get a book by ISBN
    @GetMapping("/getByIsbn/book")
    public List<Book> getByIsbn(@PathParam("isbn") Long isbn){
        return this.bookService.getBookByIsbn(isbn);
    }

    // find a book by title
    @GetMapping("/find/title")
    public List<Book> findBookByTitle(@PathParam("title") String title){
        return this.bookService.findBookByTitleContaining(title);
    }


    // find a book by title
    @GetMapping("/find/author")
    public List<Book> findBookByAuthor(@PathParam("authors") String authors){
        return this.bookService.findBookbyAuthorContaining(authors);
    }
    
    // Create a new book
    @PostMapping("/create/book")
    public Book addBook(@RequestBody Book book){
        return this.bookService.addBook(book);
    }
    
    // update an existing book
    @PutMapping("/update/book")
    public Book updateBook(@PathParam("id") Long id, @RequestBody Book book){
        return this.bookService.updateBook(id, book);
    }

    //delete a book
    @DeleteMapping("/delete/book/{id}")
    public Boolean removeBook(@PathVariable Long id){
        return this.bookService.removeBook(id);
    }

    


}
