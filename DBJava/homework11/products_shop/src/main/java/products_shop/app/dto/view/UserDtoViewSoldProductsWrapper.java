package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 16:29.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class UserDtoViewSoldProductsWrapper {

    @Expose
    @XmlAttribute(name = "count")
    private Long count;

    @Expose
    @SerializedName("products")
    @XmlElement(name = "product")
    private Set<ProductDtoAdapter> soldProductsSoldProducts;

    public UserDtoViewSoldProductsWrapper() {
    }

    public Long getCount() {
        return (long)this.soldProductsSoldProducts.size();
    }

    public void setCount() {
        this.count = (long)this.soldProductsSoldProducts.size();
    }

    public Set<ProductDtoAdapter> getSoldProductsSoldProducts() {
        return soldProductsSoldProducts;
    }

    public void setSoldProductsSoldProducts(Set<ProductDtoAdapter> soldProductsSoldProducts) {
        this.soldProductsSoldProducts = soldProductsSoldProducts;
        this.setCount();
    }
}
