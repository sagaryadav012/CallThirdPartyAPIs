package com.example.CallThirdPartyAPIs.Services;


import com.example.CallThirdPartyAPIs.DTOs.CreateAuthorDTO;
import com.example.CallThirdPartyAPIs.DTOs.UpdateGmailDTO;
import com.example.CallThirdPartyAPIs.Models.Author;
import com.example.CallThirdPartyAPIs.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service("WebClientImpl")
public class AuthorServiceWebClientImpl implements AuthorService{
    private static final String BASE_URL = "http://localhost:8080/author";
    private WebClient webClient;

    @Autowired
    public AuthorServiceWebClientImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Author createAuthor(CreateAuthorDTO authorDTO) {
        return null;
    }

    @Override
    public void deleteAuthor(long id) {

    }

    @Override
    public Author getAuthor(long id) {

        return null;
    }

    @Override
    public List<Author> getAuthors() {
        return List.of();
    }

    @Override
    public Author updateGmail(long id, UpdateGmailDTO updateGmailDTO) {
        return null;
    }
}
