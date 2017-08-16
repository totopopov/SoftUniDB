package bookshop.app.repository;

import bookshop.app.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 25.7.2017 г. at 16:59.
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{

    @Query("SELECT CONCAT(c.name,' - $',SUM(b.copies*b.price)) FROM Category AS c " +
            " INNER JOIN c.books AS b " +
            "GROUP BY c.name " +
            "ORDER BY SUM(b.copies*b.price) DESC, c.name ASC ")
    List<String> printPriceByCategory();


    @Query("SELECT c FROM Category AS c WHERE c.books.size>:size ORDER BY c.books.size DESC ")
    List<Category> findAllByCategoriesWithBooksMoreThan(@Param("size") Integer size);


}
