package bookshop.app.service.api;


import bookshop.app.models.Category;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 25.7.2017 г. at 17:01.
 */

public interface CategoryService {
    void register(Category category);

    List<String> printPriceByCategory();

    List<Category> findAllByCategoriesWithBooksMoreThan(@Param("size") Integer size);
}
