package products_shop.app.dto.bind;

import com.google.gson.annotations.Expose;
import products_shop.app.dto.view.CategoryDto;
import products_shop.app.dto.view.UserDto;


import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 12:01.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "product")
public class ProductDtoRegister {

    @Expose
    @XmlElement(name = "name")
    private String name;

    @Expose
    @XmlElement(name = "price")
    private BigDecimal price;

    @XmlTransient
    private UserDto buyer;

    @XmlTransient
    private UserDto seller;

    @XmlTransient
    private Set<CategoryDto> categories;

    public ProductDtoRegister() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UserDto getBuyer() {
        return buyer;
    }

    public void setBuyer(UserDto buyer) {
        this.buyer = buyer;
    }

    public UserDto getSeller() {
        return seller;
    }

    public void setSeller(UserDto seller) {
        this.seller = seller;
    }

    public Set<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDto> categories) {
        this.categories = categories;
    }
}
