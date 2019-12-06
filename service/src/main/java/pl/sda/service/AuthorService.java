package pl.sda.service;

import pl.sda.entities.Author;
import repository.AuthorRepository;

import java.util.List;

public class AuthorService {

private AuthorRepository authorRepository=new AuthorRepository();


    public List<Author> show(){

        return  authorRepository.show();
    }


    public Author find(long idAuthor) {

        return authorRepository.find(idAuthor);
    }
    public void save(Author author){
        authorRepository.save(author);
    }
}
