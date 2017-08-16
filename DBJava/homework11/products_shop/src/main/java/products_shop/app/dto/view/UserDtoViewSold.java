package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;
import products_shop.app.entities.Product;

import javax.xml.bind.annotation.*;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 16:29.
 */

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDtoViewSold {

    @Expose
    @XmlAttribute(name = "first-name")
    private String firstName;

    @Expose
    @XmlAttribute(name = "last-name")
    private String lastName;

    @Expose
    @XmlElementWrapper(name = "sold-products")
    @XmlElement(name = "product")
    private Set<ProductDtoViewSold> soldProducts;

    public UserDtoViewSold() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<ProductDtoViewSold> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<ProductDtoViewSold> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
