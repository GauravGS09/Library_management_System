package com.example.LibrarymanagementSystem.service;

import com.example.LibrarymanagementSystem.model.Author;
import com.example.LibrarymanagementSystem.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(Author author) {
        Author savedAuthor=authorRepository.save(author);
        return "Author saved successfully ";
    }
}
