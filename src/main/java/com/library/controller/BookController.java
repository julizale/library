package com.library.controller;

import com.library.domain.Book;
import com.library.domain.BookStatus;
import com.library.domain.dto.BookDto;
import com.library.exception.BookNotFoundException;
import com.library.exception.TitleNotFoundException;
import com.library.mapper.BookMapper;
import com.library.service.BookDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    @Autowired
    private BookDbService bookDbService;
    @Autowired
    private BookMapper bookMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> addBook (@RequestBody BookDto bookDto) throws TitleNotFoundException {
        Book book = bookMapper.mapToBook(bookDto);
        book.setBookStatus(BookStatus.IN_STOCK);
        bookDbService.saveBook(book);
        return ResponseEntity.ok(book.getId());
    }

    @PutMapping(value = "/update/{bookId}/{bookStatus}")
    public ResponseEntity<Void> changeBookStatus(@PathVariable long bookId,
                                                 @PathVariable BookStatus bookStatus) throws BookNotFoundException {
        Book book = bookDbService.getBook(bookId);
        book.setBookStatus(bookStatus);
        return ResponseEntity.ok().build();
    }

}
