package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 13:32.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDtoAdapter {

    @Expose
    @XmlAttribute(name = "name")
    private String name;

    @Expose
    @XmlAttribute(name = "price")
    private BigDecimal price;

    @XmlTransient
    private UserDtoViewFullName seller;

    public ProductDtoAdapter() {
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

    public UserDtoViewFullName getSeller() {
        return seller;
    }

    public void setSeller(UserDtoViewFullName seller) {
        this.seller = seller;
    }
}
