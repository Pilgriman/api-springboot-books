package br.com.pilgriman.bookapi.repository;

import br.com.pilgriman.bookapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
