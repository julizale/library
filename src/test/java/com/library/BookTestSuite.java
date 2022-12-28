package com.library;

import com.library.domain.Book;
import com.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // Given

    //When

    //Then

    //Cleanup
}
