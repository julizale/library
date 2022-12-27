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
@Entity(name = "TITLES")
public class Title {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    private long id;

    @Column(name = "TITLE")
    private String bookTitle;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "YEAR")
    private int yearOfPublishing;

    @OneToMany(
            targetEntity = Book.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "title"
    )
    private List<Book> bookList = new ArrayList<>();
}
