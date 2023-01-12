package com.library.controller;

import com.library.domain.Book;
import com.library.domain.dto.BookDto;
import com.library.exception.TitleNotFoundException;
import com.library.mapper.BookMapper;
import com.library.service.BookDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    @Autowired
    private BookDbService bookDbService;
    @Autowired
    private BookMapper bookMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addBook (@RequestBody BookDto bookDto) throws TitleNotFoundException {
        Book book = bookMapper.mapToBook(bookDto);
        bookDbService.saveBook(book);
        return ResponseEntity.ok().build();
    }
}
