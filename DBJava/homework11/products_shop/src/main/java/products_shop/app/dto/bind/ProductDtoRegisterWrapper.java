package products_shop.app.dto.bind;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 9.8.2017 г. at 15:57.
 */

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDtoRegisterWrapper {

    @XmlElement(name = "product")
    private List<ProductDtoRegister> products;

    public List<ProductDtoRegister> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDtoRegister> products) {
        this.products = products;
    }
}
