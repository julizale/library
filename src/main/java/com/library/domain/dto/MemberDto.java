package com.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class MemberDto {

    private long id;
    private String firstName;
    private String lastName;
    private Date accountCreated;
}
