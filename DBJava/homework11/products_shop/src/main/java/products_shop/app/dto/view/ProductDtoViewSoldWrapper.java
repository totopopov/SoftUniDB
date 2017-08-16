package products_shop.app.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 9.8.2017 г. at 16:29.
 */
@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDtoViewSoldWrapper {


    @XmlElement(name = "product")
    private Set<ProductDtoViewSold> products;
}
