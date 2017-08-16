package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 16:29.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class UserDtoViewSoldProducts {

    @Expose
    @XmlAttribute(name = "first-name")
    private String firstName;

    @Expose
    @XmlAttribute(name = "last-name")
    private String lastName;

    @Expose
    @XmlAttribute(name = "age")
    private Integer age;

    @Expose
    @XmlElement(name = "sold-products")
    private UserDtoViewSoldProductsWrapper soldProducts;

    public UserDtoViewSoldProducts() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserDtoViewSoldProductsWrapper getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(UserDtoViewSoldProductsWrapper soldProducts) {
        this.soldProducts = soldProducts;
    }
}
