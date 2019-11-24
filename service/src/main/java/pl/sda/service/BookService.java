package pl.sda.service;

import pl.sda.entities.Book;
import repository.BookRepository;

import java.util.List;

public class BookService {

    private BookRepository bookRepository=new BookRepository();


    public void save(Book book) {
        bookRepository.save(book);
    }

    public List<Book> show(){

        return  bookRepository.show();
    }

    public Book find(long id){

     return bookRepository.find(id);
    }
    public void delete(int bookId){
bookRepository.delete(bookId);
    }

    public void update(Book book) {
        bookRepository.update(book);
    }

}
