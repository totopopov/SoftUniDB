package products_shop.app.services;

import products_shop.app.dto.bind.ProductDtoRegister;

import products_shop.app.dto.view.ProductDtoView;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 2:31.
 */


public interface ProductService {
    void register(ProductDtoRegister product);

    List<ProductDtoView> findProductsByPrice(BigDecimal price, BigDecimal price2);

}
