package com.library.mapper;

import com.library.domain.Rental;
import com.library.domain.dto.RentalDto;
import com.library.exception.BookNotFoundException;
import com.library.exception.MemberNotFoundException;
import com.library.repository.BookRepository;
import com.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalMapper {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BookRepository bookRepository;

    public RentalDto mapToRentalDto(Rental rental) {
        return new RentalDto(
                rental.getId(),
                rental.getMember().getId(),
                rental.getBook().getId(),
                rental.getRentalDate(),
                rental.getReturnDate()
        );
    }

    public Rental mapToRental(RentalDto rentalDto) throws MemberNotFoundException, BookNotFoundException {
        return new Rental(
                rentalDto.getId(),
                memberRepository.findById(rentalDto.getMemberId()).orElseThrow(MemberNotFoundException::new),
                bookRepository.findById(rentalDto.getBookId()).orElseThrow(BookNotFoundException::new),
                rentalDto.getRentalDate(),
                rentalDto.getReturnDate()
        );
    }

    public List<RentalDto> mapToRentalDtoList(List<Rental> rentals) {
        return rentals.stream()
                .map(this::mapToRentalDto)
                .toList();
    }
}
