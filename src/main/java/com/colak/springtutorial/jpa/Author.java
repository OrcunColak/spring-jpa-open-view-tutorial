package com.colak.springtutorial.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Table(name = "author")

@Getter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // It will load 2 Authors
    // select * from  author a
    // select * from book b where b.author_id in (?, ?)
    @BatchSize(size = 2)
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> books;

}
