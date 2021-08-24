package br.com.pilgriman.bookapi.bookservice;


import br.com.pilgriman.bookapi.dto.BookRequestDto;
import br.com.pilgriman.bookapi.entity.Book;
import br.com.pilgriman.bookapi.exceptions.BookNotFoundException;
import br.com.pilgriman.bookapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private  BookRepository bookRepository;

    public Long createNewBook(BookRequestDto bookRequestDto) {
        Book book = new Book();

        book.setAuthor(bookRequestDto.getAuthor());
        book.setTittle(bookRequestDto.getTittle());
        book.setIsbn(bookRequestDto.getIsbn());

        book = bookRepository.save(book);

        return book.getId();
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Optional<Book> requestedBook = bookRepository.findById(id);
        if (requestedBook.isEmpty()) {
            throw new BookNotFoundException(String.format("Book with id: '%s' not found" , id));

        }

        return requestedBook.get();
    }

    @Transactional
    public Book updateBook(Long id, BookRequestDto bookToUpdateRequest){
        Optional<Book> bookFromDatabase = bookRepository.findById(id);
        if (bookFromDatabase.isEmpty()){
            throw new BookNotFoundException(String.format("Book with id: '%s' not found" , id));
        }

        Book bookToUpdate = bookFromDatabase.get();

        bookToUpdate.setAuthor(bookToUpdateRequest.getAuthor());
        bookToUpdate.setIsbn(bookToUpdateRequest.getIsbn());
        bookToUpdate.setTittle(bookToUpdateRequest.getTittle());

        return bookToUpdate;

    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
