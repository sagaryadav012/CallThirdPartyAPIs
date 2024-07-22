package com.example.CallThirdPartyAPIs.Services;

import com.example.CallThirdPartyAPIs.DTOs.CreateAuthorDTO;
import com.example.CallThirdPartyAPIs.DTOs.GetAuthorDTO;
import com.example.CallThirdPartyAPIs.DTOs.UpdateGmailDTO;
import com.example.CallThirdPartyAPIs.Models.Author;
import com.example.CallThirdPartyAPIs.Models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    public Author createAuthor(CreateAuthorDTO authorDTO);
    public void deleteAuthor(long id);
    public Author getAuthor(long id);
    public List<Author> getAuthors();
    public Author updateGmail(long id, UpdateGmailDTO updateGmailDTO);
}
