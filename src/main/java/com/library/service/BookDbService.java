package com.library.service;

import com.library.domain.Book;
import com.library.domain.BookStatus;
import com.library.domain.Member;
import com.library.exception.BookNotFoundException;
import com.library.exception.BookNotInStockException;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookDbService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBook(final long bookId) throws BookNotFoundException {
        return bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
    }

    public List<Book> getBooksOfTitle(final long titleId) {
        return bookRepository.findAll().stream()
                .filter(book -> book.getTitle().getId() == titleId)
                .collect(Collectors.toList());
    }

    public Book getBookInStockWithGivenTitleId(final long titleId) throws BookNotInStockException {
        return bookRepository.findAll().stream()
                .filter(book -> book.getTitle().getId() == titleId)
                .filter(book -> book.getBookStatus().equals(BookStatus.IN_STOCK))
                .findAny().orElseThrow(BookNotInStockException::new);
    }
}
