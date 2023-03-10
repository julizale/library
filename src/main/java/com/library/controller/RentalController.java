package com.library.controller;

import com.library.domain.Book;
import com.library.domain.BookStatus;
import com.library.domain.Member;
import com.library.domain.Rental;
import com.library.exception.BookNotFoundException;
import com.library.exception.BookNotInStockException;
import com.library.exception.MemberNotFoundException;
import com.library.exception.RentalNotFoundException;
import com.library.service.BookDbService;
import com.library.service.MemberDbService;
import com.library.service.RentalDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;

@RestController
@RequestMapping("/v1/rental")
public class RentalController {

    @Autowired
    private BookDbService bookDbService;

    @Autowired
    private RentalDbService rentalDbService;

    @Autowired
    private MemberDbService memberDbService;

    @PostMapping(value = "/rent/{memberId}/{titleId}")
    public ResponseEntity<Long> rentBook(@PathVariable long memberId, @PathVariable long titleId) throws
            Exception {
        Book book = bookDbService.getBookInStockWithGivenTitleId(titleId);
        Member member = memberDbService.getMember(memberId);
        Rental rental = Rental.builder()
                .book(book)
                .member(member)
                .rentalDate(Date.from(Instant.now()))
                .build();
        rentalDbService.saveRental(rental);
        book.setBookStatus(BookStatus.BORROWED);
        bookDbService.saveBook(book);
        return ResponseEntity.ok(book.getId());
    }

    @PutMapping(value = "/return/{memberId}/{bookId}")
    public ResponseEntity<Void> returnBook(@PathVariable long memberId, @PathVariable long bookId) throws Exception {
        Book book = bookDbService.getBook(bookId);
        Rental rental = rentalDbService.getCurrentRentalsByMember(memberId).stream()
                .filter(r -> r.getBook().equals(book))
                .findAny().orElseThrow(RentalNotFoundException::new);
        rental.setReturnDate(Date.from(Instant.now()));
        rentalDbService.saveRental(rental);
        book.setBookStatus(BookStatus.IN_STOCK);
        bookDbService.saveBook(book);
        return ResponseEntity.ok().build();
    }

}
