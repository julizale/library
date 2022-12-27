package com.library.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID")
    private Title title;

    @NotNull
    @Column(name = "STATUS")
    private BookStatus bookStatus;

    @OneToMany(
            targetEntity = Rental.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "book"
    )
    private List<Rental> rentalList = new ArrayList<>();
}
