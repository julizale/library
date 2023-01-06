package com.library.domain.dto;

import com.library.domain.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {

    private long id;
    private long titleId;
    private String bookTitle;
    private String author;
    private BookStatus bookStatus;
}
