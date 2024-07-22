package com.example.CallThirdPartyAPIs.DTOs;

import lombok.Data;

import java.util.Date;

@Data
public class CreateBookDTO {
    private String name;
    private Date published_date;
}
