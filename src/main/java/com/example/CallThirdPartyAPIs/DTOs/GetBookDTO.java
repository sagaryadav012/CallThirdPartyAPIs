package com.example.CallThirdPartyAPIs.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class GetBookDTO {
    private long id;
    private String name;
    private Date published_date;
}
