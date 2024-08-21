package com.colak.springtutorial.controller;

import com.colak.springtutorial.dto.AuthorDto;
import com.colak.springtutorial.jpa.Author;
import com.colak.springtutorial.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class CustomerController {

    private final AuthorService authorService;

    // http://localhost:8080/1
    // This will throw exception
    // org.hibernate.LazyInitializationException: could not initialize proxy [com.colak.springtutorial.jpa.Author#1] - no Session
    @GetMapping("/{id}")
    AuthorDto getCustomer(@PathVariable Long id) {
        Author author = authorService.getAuthor(id);
        return new AuthorDto(author.getId(), author.getBooks().size());
    }
}
