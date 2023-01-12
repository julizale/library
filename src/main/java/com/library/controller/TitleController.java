package com.library.controller;

import com.library.domain.BookStatus;
import com.library.domain.Title;
import com.library.domain.dto.TitleDto;
import com.library.mapper.TitleMapper;
import com.library.service.BookDbService;
import com.library.service.TitleDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/titles")
public class TitleController {

    @Autowired
    private TitleDbService titleDbService;
    @Autowired
    private TitleMapper titleMapper;
    @Autowired
    private BookDbService bookDbService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> addTitle(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        titleDbService.saveTitle(title);
        return ResponseEntity.ok(title.getId());
    }

    @GetMapping(value = "/instock/{titleId}")
    public ResponseEntity<Integer> countBooksInStock(@PathVariable Long titleId) {
        long count = bookDbService.getBooksOfTitle(titleId).stream()
                .filter(book -> book.getBookStatus().equals(BookStatus.IN_STOCK))
                .count();
        return ResponseEntity.ok((int) count);
    }
}

