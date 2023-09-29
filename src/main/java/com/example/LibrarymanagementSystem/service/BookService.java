package com.example.LibrarymanagementSystem.service;

import com.example.LibrarymanagementSystem.exception.AuthorNotFoundException;
import com.example.LibrarymanagementSystem.model.Author;
import com.example.LibrarymanagementSystem.model.Book;
import com.example.LibrarymanagementSystem.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;


    public String addBook(Book book) {
          //check if author exists or not
        Optional<Author> authorOptional=authorRepository.findById(book.getAuthor().getId());
         if(authorOptional.isEmpty()){
             throw new AuthorNotFoundException("Invalid author id");
         }
         Author author=authorOptional.get();
         book.setAuthor(author);
         author.getBooks().add(book);
         authorRepository.save(author);//save both author and book

         return "Book added successfully";

}
}