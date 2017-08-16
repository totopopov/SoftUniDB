package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 13:32.
 */

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDtoView {
    @Expose
    @XmlAttribute(name = "name")
    private String name;

    @Expose
    @XmlAttribute(name = "price")
    private BigDecimal price;

    @Expose
    @SerializedName("seller")
    @XmlAttribute(name = "seller")
    private String sellerFullName;

    public ProductDtoView() {
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

    public String getSellerFullName() {
        return sellerFullName;
    }

    public void setSellerFullName(String sellerFullName) {
        this.sellerFullName = sellerFullName;
    }
}
