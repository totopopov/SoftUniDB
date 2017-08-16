package products_shop.app.dto.bind;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 9.8.2017 г. at 15:47.
 */


@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryDtoRegisterWrapper {

    @XmlElement(name = "category")
    private List<CategoryDtoRegister> categories;


    public List<CategoryDtoRegister> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDtoRegister> categories) {
        this.categories = categories;
    }
}
