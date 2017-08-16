package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 13:32.
 */

//@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDtoViewSold {

    @Expose
    @XmlElement(name="name")
    private String name;

    @Expose
    @XmlElement(name="price")
    private BigDecimal price;

    @Expose
    @XmlElement(name="buyer-first-name")
    private String buyerFirstName;

    @Expose
    @XmlElement(name="buyer-last-name")
    private String buyerLastName;

    public ProductDtoViewSold() {
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

    public String getBuyerFirstName() {
        return buyerFirstName;
    }

    public void setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
    }

    public String getBuyerLastName() {
        return buyerLastName;
    }

    public void setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
    }
}
