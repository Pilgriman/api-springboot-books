package br.com.pilgriman.bookapi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
public class BookRequestDto {


    @NotEmpty
    private String tittle;

    @NotEmpty
    @Size(max = 20)
    private String isbn;

    @NotEmpty
    private String author;
}
