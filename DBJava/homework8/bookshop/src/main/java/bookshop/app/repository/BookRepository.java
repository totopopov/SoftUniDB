package bookshop.app.repository;

import bookshop.app.models.AgeRestriction;
import bookshop.app.models.Author;
import bookshop.app.models.Book;
import bookshop.app.models.EditionType;
import org.hibernate.boot.jaxb.hbm.spi.Adapter4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 25.7.2017 г. at 16:57.
 */
@Service
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book AS b WHERE YEAR(b.releaseDate)>:year")
    List<Book> findBookByReleaseDateYearAFter(@Param("year") int year);

    List<Book> findBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String author_firstName, String author_lastName);

    @Query("SELECT distinct b.title FROM Book AS b WHERE b.ageRestriction=:ageRestriction")
    List<Object> findAllBooksByAgeRestriction(@Param("ageRestriction") AgeRestriction ageRestriction);

    @Query("SELECT b.title FROM Book AS b WHERE b.editionType=:editionType AND b.copies<:copies")
    List<Object> findAllBooksByTypeAndCopies(@Param("editionType") EditionType editionType, @Param("copies") Long copies);

    @Query("SELECT b.title, b.price FROM Book AS b WHERE b.price NOT BETWEEN :low AND :high")
    List<Object[]> findAllBooksByPriceBound(@Param("low") BigDecimal low, @Param("high") BigDecimal high);

    @Query("SELECT  DISTINCT b.title FROM Book AS b WHERE YEAR(b.releaseDate)!=:year")
    List<Object> findAllNotReleasedOn(@Param("year") int yearOfRelease);

    @Query("SELECT b.title FROM Book AS b " +
            "INNER JOIN b.categories AS c " +
            "WHERE lower( c.name ) IN :categories ")
    List<Object> findAllByCateriesList(@Param("categories") String[] categories);

    @Query("SELECT b.title, b.editionType, b.price FROM Book AS b WHERE b.releaseDate<:date")
    List<Object[]> getAllBooksBeforeDate(@Param("date") Date date);


    List<Book> findAllByTitleIgnoreCaseContaining(String title);


    List<Book> findAllByAuthorLastNameIgnoreCaseStartingWith(String author_lastName);

    @Query("SELECT count(b) from Book b where LENGTH( b.title)>:size")
    Integer countBookWithTitleGreaterThan(@Param("size") Integer lenght);

    @Query("SELECT b.title, b.editionType, b.ageRestriction, b.price FROM Book AS b" +
            " WHERE b.title=:title")
    List<Object[]> findBookByTitle(@Param("title") String title);


    @Modifying
    @Query("UPDATE Book AS b SET b.copies=b.copies+:copies WHERE b.releaseDate>:date")
    Integer increseCopiesOfBooksAfter(@Param("date") Date date,@Param("copies") Long copies);


    @Modifying
    Integer deleteAllByCopiesLessThan(Long copies);

}
