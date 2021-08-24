package br.com.pilgriman.bookapi.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String tittle;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private String author;


}
