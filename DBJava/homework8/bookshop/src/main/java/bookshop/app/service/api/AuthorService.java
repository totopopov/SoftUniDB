package bookshop.app.service.api;

import bookshop.app.models.Author;



import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 25.7.2017 г. at 17:01.
 */

public interface AuthorService {
    void register(Author author);

    List<Author> findAuthorsByReleaseDateBefore(int year);

    List<Author> findAllOrderByBookCount();

    List<Author> findAllByFirstNameEndingWith(String firstName);

    List<String> printCopiesByAuthors();

}
