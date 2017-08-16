package bookshop.app.repository;

import bookshop.app.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 25.7.2017 г. at 16:58.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author,Long>{

    @Query("SELECT DISTINCT b.author FROM Book AS b WHERE YEAR(b.releaseDate)<:year")
    List<Author> findAuthorsByReleaseDateBefore(@Param("year") int year);


    @Query("SELECT a FROM Author AS a ORDER BY a.books.size DESC")
    List<Author> findAllOrderByBookCount();


    List<Author> findAllByFirstNameEndingWith(String firstName);

    @Query("SELECT concat(a.firstName,' ',a.lastName,' - ', SUM(b.copies))  FROM Author AS a" +
            " INNER JOIN a.books AS b " +
            " GROUP BY a.firstName,a.lastName " +
            "ORDER BY SUM(b.copies) DESC")
    List<String> printCopiesByAuthors();

}
