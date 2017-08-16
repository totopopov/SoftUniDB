package bookshop.app.service.api;

import bookshop.app.models.AgeRestriction;
import bookshop.app.models.Author;
import bookshop.app.models.Book;
import bookshop.app.models.EditionType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 25.7.2017 г. at 17:01.
 */

public interface BookService {
    void register(Book book);

    List<Book> findBookByReleaseDateYearAFter(int year);

    List<Book> findBooksByAuthorOrdered(String firstName,String lastName);

    List<Book> findall();


    List<Object> findAllBooksByAgeRestriction( AgeRestriction ageRestriction);

    List<Object> findAllBooksByTypeAndCopies( EditionType editionType, Long copies);

    List<Object[]> findAllBooksByPriceBound(BigDecimal low, BigDecimal high);

    List<Object> findAllNotReleasedOn(int yearOfRelease);

    List<Object> findAllByCateriesList(@Param("categories") String[] categories);

    List<Object[]> getAllBooksBeforeDate(Date date);

    List<Book> findAllByTitleIgnoreCaseContaining(String title);

    List<Book> findAllByAuthorLastNameIgnoreCaseStartingWith(String author_lastName);

    Integer countBookByLengthTitleGreaterThan(Integer lenght);

    List<Object[]> findBookByTitle(@Param("title") String title);

    Integer increseCopiesOfBooksAfter(@Param("date") Date date,@Param("copies") Long copies);

    Integer deleteAllByCopiesLessThan(Long copies);

}
