package com.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TitleDto {

    private long id;
    private String bookTitle;
    private String author;
    private int yearOfPublishing;
}
