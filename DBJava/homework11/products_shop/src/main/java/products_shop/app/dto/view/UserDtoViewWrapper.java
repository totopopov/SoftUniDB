package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 3:04.
 */

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDtoViewWrapper {

    @Expose
    @XmlAttribute(name = "count")
    private Long usersCount;

    @Expose
    @SerializedName("users")
    @XmlElement(name = "user")
    private List<UserDtoViewSoldProducts> userDtoViewSoldProducts;


    public UserDtoViewWrapper() {
    }

    public Long getCount() {
        return (long)this.userDtoViewSoldProducts.size();
    }

    public void setUsersCount() {
        this.usersCount = (long)this.userDtoViewSoldProducts.size();;
    }

    public List<UserDtoViewSoldProducts> getUserDtoViewSoldProducts() {
        return userDtoViewSoldProducts;
    }

    public void setUserDtoViewSoldProducts(List<UserDtoViewSoldProducts> userDtoViewSoldProducts) {
        this.userDtoViewSoldProducts = userDtoViewSoldProducts;
    }
}
