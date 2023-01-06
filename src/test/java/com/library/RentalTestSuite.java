package com.library;

import com.library.domain.Rental;
import com.library.repository.RentalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testRentalRepositoryFindById() {
        //Given
        Rental rental = new Rental();
        rentalRepository.save(rental);
        long rentalId = rental.getId();
        //When
        Optional<Rental> rentalFoundById = rentalRepository.findById(rentalId);
        //Then
        assertTrue(rentalFoundById.isPresent());
        //Cleanup
        rentalRepository.deleteById(rentalId);
    }

    @Test
    void testRentalRepositorySave() {
        //Given
        Rental rental = new Rental();

        //When
        rentalRepository.save(rental);
        long rentalId = rental.getId();

        //Then
        try {
            assertNotEquals(0, rentalId);
        } finally {
            rentalRepository.deleteById(rentalId);
        }
    }

    @Test
    void testRentalRepositoryDeleteById() {
        //Given
        Rental rental = new Rental();
        rentalRepository.save(rental);
        long rentalId = rental.getId();

        //When
        rentalRepository.deleteById(rentalId);
        Optional<Rental> rentalFoundById = rentalRepository.findById(rentalId);

        //Then
        assertFalse(rentalFoundById.isPresent());
    }
}
