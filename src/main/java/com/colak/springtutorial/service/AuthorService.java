package com.colak.springtutorial.service;

import com.colak.springtutorial.jpa.Author;
import com.colak.springtutorial.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository repository;

    @Transactional
    public Author getAuthor(Long id) {
        return repository.getReferenceById(id);
    }
}
