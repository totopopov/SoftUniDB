package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import products_shop.app.entities.Product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 11:52.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryDtoView {

    @Expose
    @SerializedName("category")
    @XmlAttribute(name = "name")
    private String name;

    @Expose
    @SerializedName("productsCount")
    @XmlElement(name = "products-count")
    private Long count;

    @Expose
    @XmlElement(name = "average-price")
    private BigDecimal averagePrice;

    @Expose
    @XmlElement(name = "total-revenue")
    private BigDecimal totalRevenue;

    public CategoryDtoView() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
