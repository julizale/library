package com.library;

import com.library.domain.Book;
import com.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@Transactional
public class BookTestSuite {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testBookRepositoryFindAll() {
        // Given
        Book book = new Book();
        bookRepository.save(book);
        long bookId = book.getId();

        //When
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        //Then
        assertTrue(optionalBook.isPresent());

        //Cleanup
        bookRepository.deleteById(bookId);
    }

    @Test
    void testBookRepositoryFindById() {
        //Given
        Book book = new Book();
        bookRepository.save(book);
        long bookId = book.getId();
        //When
        Optional<Book> bookFoundById = bookRepository.findById(bookId);
        //Then
        assertTrue(bookFoundById.isPresent());
        //Cleanup
        bookRepository.deleteById(bookId);
    }

    @Test
    void testBookRepositorySave() {
        //Given
        Book book = new Book();

        //When
        bookRepository.save(book);
        long bookId = book.getId();

        //Then
        try {
            assertNotEquals(0, bookId);
        } finally {
            bookRepository.deleteById(bookId);
        }
    }

    @Test
    void testBookRepositoryDeleteById() {
        //Given
        Book book = new Book();
        bookRepository.save(book);
        long bookId = book.getId();

        //When
        bookRepository.deleteById(bookId);
        Optional<Book> bookFoundById = bookRepository.findById(bookId);

        //Then
        assertFalse(bookFoundById.isPresent());
    }
}
