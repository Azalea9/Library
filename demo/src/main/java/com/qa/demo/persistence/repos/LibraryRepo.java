package com.qa.demo.persistence.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.demo.persistence.domain.Book;


@Repository
public interface LibraryRepo extends JpaRepository<Book, Long> {
    Book findByIsbn(Long isbn);
    List<Book> findByAuthorsContaining(String authors);
    List<Book> findByTitleContaining(String title);
}

