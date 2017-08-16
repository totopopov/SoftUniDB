package exam.hiber_spring.services;

import exam.hiber_spring.dto.bind.ProductDtoRegister;
import exam.hiber_spring.entitites.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(long id);

    Product create(Product product);

    List<Product> multipleCreate(Iterable<Product> products);

    void deleteById(long id);

    String register(ProductDtoRegister productDtoRegister);
}
