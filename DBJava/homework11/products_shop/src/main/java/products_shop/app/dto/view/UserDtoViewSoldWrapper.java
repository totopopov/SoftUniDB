package products_shop.app.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 9.8.2017 г. at 16:43.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class UserDtoViewSoldWrapper {

    private List<UserDtoViewSold> users;

    public List<UserDtoViewSold> getUsers() {
        return users;
    }

    public void setUsers(List<UserDtoViewSold> users) {
        this.users = users;
    }
}
