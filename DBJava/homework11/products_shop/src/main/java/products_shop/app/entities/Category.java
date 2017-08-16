package products_shop.app.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 3.8.2017 г. at 21:52.
 */

@Entity
@Table(name = "categories")
public class Category {


    private Long id;

    private String name;

    private Set<Product> products;

    public Category() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER)
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }



}
