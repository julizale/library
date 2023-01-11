package com.library.mapper;

import com.library.domain.Book;
import com.library.domain.dto.BookDto;
import com.library.exception.TitleNotFoundException;
import com.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookMapper {

    @Autowired
    private TitleRepository titleRepository;

    public BookDto mapToBookDto(Book book) {
        return new BookDto(book.getId(), book.getTitle().getId(), book.getTitle().getBookTitle(),
                book.getTitle().getAuthor(), book.getBookStatus());
    }

    public Book mapToBook(BookDto bookDto) throws TitleNotFoundException {
        return new Book(bookDto.getId(),
                titleRepository.findById(bookDto.getTitleId()).orElseThrow(TitleNotFoundException::new),
                bookDto.getBookStatus(),
                new ArrayList<>());
    }

    public List<BookDto> mapToBookDtoList(List<Book> books) {
        return books.stream()
                .map(this::mapToBookDto)
                .toList();
    }
}
