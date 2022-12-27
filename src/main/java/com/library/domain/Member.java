package com.library.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "MEMBERS")
public class Member {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @NotNull
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull
    @Column(name = "DATE")
    private Date accountCreated;

    @OneToMany(
            targetEntity = Rental.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "member"
    )
    private List<Rental> rentalList = new ArrayList<>();
}
