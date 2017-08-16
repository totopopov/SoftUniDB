package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 13:32.
 */

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDtoViewWrapper {

    @XmlElement(name = "product")
    private List<ProductDtoView> products;


    public List<ProductDtoView> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDtoView> products) {
        this.products = products;
    }
}
