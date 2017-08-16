package products_shop.app.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 9.8.2017 г. at 16:54.
 */

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryDtoViewWrapper {

    @XmlElement(name = "category")
    private List<CategoryDtoView> categoriesALL;

    public List<CategoryDtoView> getCategoriesALL() {
        return categoriesALL;
    }

    public void setCategoriesALL(List<CategoryDtoView> categoriesALL) {
        this.categoriesALL = categoriesALL;
    }
}
