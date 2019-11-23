package pl.sda.service;

import pl.sda.entities.Book;
import repository.BookRepository;

public class BookService {

    private BookRepository bookRepository=new BookRepository();


    public void save(Book book) {
        bookRepository.save(book);
    }
}
