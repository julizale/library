package com.library.controller;

import com.library.domain.Title;
import com.library.domain.dto.TitleDto;
import com.library.mapper.TitleMapper;
import com.library.service.TitleDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/titles")
public class TitleController {

    @Autowired
    private TitleDbService titleDbService;
    @Autowired
    private TitleMapper titleMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addTitle(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        titleDbService.saveTitle(title);
        return ResponseEntity.ok().build();
    }
}

