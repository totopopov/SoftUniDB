package products_shop.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import products_shop.app.entities.Product;
import products_shop.app.entities.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 2:29.
 */

@Repository
public interface ProductRepositery extends JpaRepository<Product, Long> {

    List<Product> findProductsByBuyerIsNullAndPriceBetweenOrderByPriceAsc(BigDecimal price, BigDecimal price2);


}
