package com.library;

import com.library.domain.Book;
import com.library.domain.Rental;
import com.library.repository.RentalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
public class RentalTestSuite {

    @Autowired
    private RentalRepository rentalRepository;

    @Test
    void testBookRepositoryFindAll() {
        // Given
        Rental rental = new Rental();
        rentalRepository.save(rental);
        long rentalId = rental.getId();

        //When
        Optional<Rental> optionalRental = rentalRepository.findById(rentalId);

        //Then
        assertTrue(optionalRental.isPresent());

        //Cleanup
        rentalRepository.deleteById(rentalId);
    }
}
