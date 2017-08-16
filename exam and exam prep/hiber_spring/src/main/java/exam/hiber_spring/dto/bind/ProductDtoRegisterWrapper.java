package exam.hiber_spring.dto.bind;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 9:27.
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
