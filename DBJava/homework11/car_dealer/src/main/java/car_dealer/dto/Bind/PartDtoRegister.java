package car_dealer.dto.Bind;

import car_dealer.app.entities.Supplier;
import car_dealer.dto.View.SupplierViewBasic;
import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 22:10.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class PartDtoRegister {

    @Expose
    @XmlAttribute(name = "name")
    private String name;

    @Expose
    @XmlAttribute(name = "price")
    private BigDecimal price;

    @Expose
    @XmlAttribute(name = "quantity")
    private Long quantity;


    private SupplierViewBasic supplier;

    public PartDtoRegister() {
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public SupplierViewBasic getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierViewBasic supplier) {
        this.supplier = supplier;
    }
}
