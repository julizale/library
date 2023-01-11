package com.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RentalDto {

    private long id;
    private long memberId;
    private long bookId;
    private Date rentalDate;
    private Date returnDate;
}
