package bookshop.app.service.impl;

import bookshop.app.models.Category;
import bookshop.app.repository.CategoryRepository;
import bookshop.app.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 25.7.2017 г. at 17:06.
 */


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void register(Category category) {
        categoryRepository.saveAndFlush(category);
    }

    @Override
    public List<String> printPriceByCategory() {
        return this.categoryRepository.printPriceByCategory();
    }

    @Transactional
    @Override
    public List<Category> findAllByCategoriesWithBooksMoreThan(Integer size) {
        return this.categoryRepository.findAllByCategoriesWithBooksMoreThan(size);
    }
}
