package com.library;

import com.library.domain.Book;
import com.library.domain.Title;
import com.library.repository.TitleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class TitleTestSuite {

    @Autowired
    private TitleRepository titleRepository;

    @Test
    void testBookRepositoryFindAll() {
        // Given
        Title title = new Title();
        titleRepository.save(title);
        long titleId = title.getId();

        //When
        Optional<Title> optionalTitle = titleRepository.findById(titleId);

        //Then
        try {
            assertTrue(optionalTitle.isPresent());
        } finally {
            //Cleanup
            titleRepository.deleteById(titleId);
        }
    }

    @Test
    void testTitleRepositoryFindById() {
        //Given
        Title title = new Title();
        titleRepository.save(title);
        long titleId = title.getId();
        //When
        Optional<Title> titleFoundById = titleRepository.findById(titleId);
        try {
            assertTrue(titleFoundById.isPresent());
        } finally {
            //Cleanup
            titleRepository.deleteById(titleId);
        }
    }

    @Test
    void testTitleRepositorySave() {
        //Given
        Title title = new Title();
        Book book = new Book();
        title.getBookList().add(book);
        book.setTitle(title);

        //When
        titleRepository.save(title);
        long titleId = title.getId();
        long bookId = book.getId();
        //Then
        try {
            assertNotEquals(0, titleId);
            assertNotEquals(0, bookId);
        } finally {
            titleRepository.deleteById(titleId);
        }
    }

    @Test
    void testTitleRepositoryDeleteById() {
        //Given
        Title title = new Title();
        titleRepository.save(title);
        long titleId = title.getId();

        //When
        titleRepository.deleteById(titleId);
        Optional<Title> titleFoundById = titleRepository.findById(titleId);

        //Then
        assertFalse(titleFoundById.isPresent());
    }
}
