package com.example.CallThirdPartyAPIs.Controllers;

import com.example.CallThirdPartyAPIs.DTOs.CreateAuthorDTO;
import com.example.CallThirdPartyAPIs.DTOs.CreateBookDTO;
import com.example.CallThirdPartyAPIs.DTOs.UpdateGmailDTO;
import com.example.CallThirdPartyAPIs.Models.Author;
import com.example.CallThirdPartyAPIs.Models.Book;
import com.example.CallThirdPartyAPIs.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/callAuthor")
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(@Qualifier("RestTemplateImpl") AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/fetchAuthor/{id}")
    public ResponseEntity<Author> fetchAuthor(@PathVariable long id){
        Author author = this.authorService.getAuthor(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @GetMapping("/fetchAuthors")
    public ResponseEntity<List<Author>> fetchAuthors(){
        List<Author> authors = this.authorService.getAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PostMapping("/createAuthor")
    public ResponseEntity<Author> createAuthor(@RequestBody CreateAuthorDTO authorDTO){
        Author author = this.authorService.createAuthor(authorDTO);
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable long id){
        this.authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateGmail/{id}")
    public ResponseEntity<Author> updateGmail(@PathVariable long id, @RequestBody UpdateGmailDTO updateGmailDTO){
        Author author = this.authorService.updateGmail(id, updateGmailDTO);
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }
}
