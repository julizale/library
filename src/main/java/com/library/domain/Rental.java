package com.library.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity(name = "RENTALS")
public class Rental {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "ID")
    private Book book;

    @Column(name = "DATE_RENTAL")
    private Date rentalDate;

    @Column(name = "DATE_RETURN")
    private Date returnDate;
}
