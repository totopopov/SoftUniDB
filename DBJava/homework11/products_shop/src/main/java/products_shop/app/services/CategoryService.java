package products_shop.app.services;

import products_shop.app.dto.bind.CategoryDtoRegister;
import products_shop.app.dto.view.CategoryDto;
import products_shop.app.dto.view.CategoryDtoView;
import products_shop.app.entities.Category;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 2:31.
 */


public interface CategoryService {
    void register(CategoryDtoRegister category);
    List<CategoryDto> findAll();
    List<CategoryDtoView> findAllOrderedByProductCount();
}
