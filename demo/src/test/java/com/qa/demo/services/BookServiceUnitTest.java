package com.qa.demo.services;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.demo.persistence.domain.Book;
import com.qa.demo.persistence.repos.LibraryRepo;


@SpringBootTest
public class BookServiceUnitTest {

    @Autowired
    private BookService service;

    @MockBean
    private LibraryRepo repo;


    @Test
    void testCreateBook(){
        Book newBook = new Book(null, 1020304050601L, "The Happy Bunny", "Simon Green");
        Book createdBook = new Book(1L, 1020304050601L, "The Happy Bunny", "Simon Green");

        Mockito.when(this.repo.save(newBook)).thenReturn(createdBook);

        Assertions.assertThat(this.service.addBook(newBook)).isEqualTo(createdBook);

    }

    @Test
    void testGetAllBooks(){
        final List<Book> books = List.of(new Book(1L,1020304050601L, "The Happy Bunny", "Simon Green"),
                    new Book(2L, 1092939299192L, "The Hunger Games", "Gareth Greaves"));

        Mockito.when(this.repo.findAll()).thenReturn(books);

        Assertions.assertThat(books.size()).isGreaterThan(0);

    }
    
    @Test
    void testFindByIsbn(){
        final Long isbn = 1020304050601L;
        final Book newBook = new Book(1L,1020304050601L, "The Happy Bunny", "Simon Green");
        
        Mockito.when(this.repo.findByIsbn(isbn)).thenReturn(newBook);
        Assertions.assertThat(this.service.getBookByIsbn(isbn)).isEqualTo(newBook);
        Mockito.verify(this.repo, Mockito.times(1)).findByIsbn(isbn);
    }

    @Test
    void testFindByTitle(){
        final String title = "The Happy Bunny";
        final List<Book> newBook = List.of(new Book(1L,1020304050601L, "The Happy Bunny", "Simon Green"));

        Mockito.when(this.repo.findByTitleContaining(title)).thenReturn(newBook);
        Assertions.assertThat(this.service.findBookByTitle(title)).isEqualTo(newBook);
        Mockito.verify(this.repo, Mockito.times(1)).findByTitleContaining(title);
    }

    @Test
    void testFindByAuthor(){
        final String author = "Simon Green";
        final List<Book> newBook = List.of(new Book(1L,1020304050601L, "The Happy Bunny", "Simon Green"));

        Mockito.when(this.repo.findByAuthorsContaining(author)).thenReturn(newBook);
        Assertions.assertThat(this.service.findBookbyAuthor(author)).isEqualTo(newBook);
        Mockito.verify(this.repo, Mockito.times(1)).findByAuthorsContaining(author);
    }

    // @Test
    // void testUpdateBook(){
    // TO DO
    // }

    @Test
    void testDeleteBook(){
        final Long id = 1L;

        Mockito.when(this.repo.existsById(id)).thenReturn(false);
        Assertions.assertThat(this.service.removeBook(id)).isEqualTo(true);

        Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
    }
}
