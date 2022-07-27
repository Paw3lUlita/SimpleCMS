package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Author;
import pl.coderslab.repository.AuthorRepository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void save(Author author){
        authorRepository.save(author);
    }

    public Author findById(long id){
        return authorRepository.findById(id).get();
    }

    public List<Author> findAll(){

        return authorRepository.findAll();

    }

    public void update(Author author) {
        authorRepository.save(author);
    }

    public void deleteById(long id){
        authorRepository.deleteById(id);
    }
}