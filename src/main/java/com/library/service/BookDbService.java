package com.library.service;

import com.library.domain.Book;
import com.library.domain.Member;
import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookDbService {

    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}
