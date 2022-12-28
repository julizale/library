package com.library.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "RENTALS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rental {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "MEBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @Column(name = "DATE_RENTAL")
    private Date rentalDate;

    @Column(name = "DATE_RETURN")
    private Date returnDate;
}
