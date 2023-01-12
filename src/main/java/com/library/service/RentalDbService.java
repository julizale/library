package com.library.service;

import com.library.domain.Book;
import com.library.domain.Rental;
import com.library.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalDbService {

    @Autowired
    private RentalRepository rentalRepository;

    public Rental saveRental(Rental rental) {
        return (rentalRepository.save(rental));
    }

    public List<Rental> getCurrentRentalsByMember(final long memberId) {
        return rentalRepository.findAll().stream()
                .filter(rental -> rental.getMember().getId() == memberId)
                .filter(rental -> rental.getReturnDate() == null)
                .collect(Collectors.toList());
    }
}
