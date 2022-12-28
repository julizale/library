package com.library;

import com.library.domain.Book;
import com.library.domain.Title;
import com.library.repository.TitleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(optionalTitle.isPresent());

        //Cleanup
        titleRepository.deleteById(titleId);
    }
}
