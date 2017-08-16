package bookshop.app.service.impl;

import bookshop.app.models.Author;
import bookshop.app.repository.AuthorRepository;
import bookshop.app.repository.BookRepository;
import bookshop.app.service.api.AuthorService;
import bookshop.app.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 25.7.2017 г. at 17:03.
 */

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;


    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void saveAuthor(Author author){
        this.authorRepository.save(author);
    }

    @Override
    public void register(Author author) {
        authorRepository.saveAndFlush(author);
    }

    @Override
    public List<Author> findAuthorsByReleaseDateBefore(int year) {
        return authorRepository.findAuthorsByReleaseDateBefore(1990);
    }

    @Override
    public List<Author> findAllOrderByBookCount() {
        return authorRepository.findAllOrderByBookCount();
    }

    @Override
    public List<Author> findAllByFirstNameEndingWith(String firstName) {
        return this.authorRepository.findAllByFirstNameEndingWith(firstName);
    }

    @Override
    public List<String> printCopiesByAuthors() {
        return this.authorRepository.printCopiesByAuthors();
    }
}
