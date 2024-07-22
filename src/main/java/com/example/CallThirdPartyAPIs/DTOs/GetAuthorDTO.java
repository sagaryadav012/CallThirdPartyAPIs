package com.example.CallThirdPartyAPIs.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class GetAuthorDTO {
    private long id;
    private String name;
    private String gmail;
    private List<GetBookDTO> books;
}
