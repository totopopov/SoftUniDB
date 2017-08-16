package car_dealer.dto.View;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

/**
 * Created by Todor Popov using Lenovo on 9.8.2017 г. at 23:22.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class SaleDtoViewDetailed {

    @XmlElement(name = "car")
    private CarDtoViewSalesInfo carDtoViewSalesInfo;

    @XmlElement(name = "customer-name")
    private String name;

    @XmlElement(name = "discount")
    private BigDecimal discount;

    @XmlElement(name = "price")
    private BigDecimal price;

    @XmlElement(name = "price-with-discount")
    private  BigDecimal priceWithDiscount;

    public SaleDtoViewDetailed() {
    }

    public SaleDtoViewDetailed(CarDtoViewSalesInfo carDtoViewSalesInfo, String name, BigDecimal discount, BigDecimal price, BigDecimal priceWithDiscount) {
        this.carDtoViewSalesInfo = carDtoViewSalesInfo;
        this.name = name;
        this.discount = discount;
        this.price = price;
        this.priceWithDiscount = priceWithDiscount;
    }

    public CarDtoViewSalesInfo getCarDtoViewSalesInfo() {
        return carDtoViewSalesInfo;
    }

    public void setCarDtoViewSalesInfo(CarDtoViewSalesInfo carDtoViewSalesInfo) {
        this.carDtoViewSalesInfo = carDtoViewSalesInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
