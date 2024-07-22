package com.example.CallThirdPartyAPIs.Services;

import com.example.CallThirdPartyAPIs.DTOs.*;
import com.example.CallThirdPartyAPIs.Models.Author;
import com.example.CallThirdPartyAPIs.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service("RestTemplateImpl")
public class AuthorServiceRestTemplateImpl implements AuthorService{
    private RestTemplate restTemplate;
    private static final String BASE_URL = "http://localhost:8080/author";

    @Autowired
    public AuthorServiceRestTemplateImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Author createAuthor(CreateAuthorDTO authorDTO) {
        return restTemplate.postForObject(BASE_URL + "/createAuthor", authorDTO, Author.class);
    }

    @Override
    public void deleteAuthor(long id) {
        restTemplate.delete(BASE_URL+"/"+id);
    }

    @Override
    public Author getAuthor(long id) {
        GetAuthorDTO authorDTO = restTemplate.getForObject(BASE_URL + "/fetchAuthor/" + id, GetAuthorDTO.class);

        assert authorDTO != null;

        return convertToAuthor(authorDTO);
    }

    @Override
    public List<Author> getAuthors() {
        GetAuthorDTO[] authorDTOS = this.restTemplate.getForObject(BASE_URL + "/fetchAuthors", GetAuthorDTO[].class);
        List<Author> authors = new ArrayList<>();

        assert authorDTOS != null;
        for (GetAuthorDTO authorDTO : authorDTOS) {
            authors.add(convertToAuthor(authorDTO));
        }
        return authors;
    }

    @Override
    public Author updateGmail(long id, UpdateGmailDTO updateGmailDTO) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UpdateGmailDTO> entity = new HttpEntity<>(updateGmailDTO, httpHeaders);

        ResponseEntity<Author> response = restTemplate.exchange(BASE_URL + "/updateGmail/" + id, HttpMethod.PATCH, entity, Author.class);
        return response.getBody();
    }

    public Author convertToAuthor(GetAuthorDTO authorDTO){
        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        author.setGmail(authorDTO.getGmail());

        List<Book> books = new ArrayList<>();
        for (GetBookDTO bookDTO : authorDTO.getBooks()) {
            Book book = new Book();
            book.setId(bookDTO.getId());
            book.setName(bookDTO.getName());
            book.setPublished_date(bookDTO.getPublished_date());
            books.add(book);
        }
        author.setBooks(books);
        return author;
    }
}