package products_shop.app.dto.bind;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 11:52.
 */

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryDtoRegister {

    @Expose
    @XmlElement(name ="name")
    private String name;

    public CategoryDtoRegister() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
