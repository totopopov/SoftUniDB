package products_shop.app.dto.bind;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 9.8.2017 г. at 15:07.
 */

@XmlRootElement(name ="users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDtoRegisterWrapper {

    @XmlElement(name = "user")
    private List<UserDtoRegister> userDtoRegisters;

    public List<UserDtoRegister> getUserDtoRegisters() {
        return userDtoRegisters;
    }

    public void setUserDtoRegisters(List<UserDtoRegister> userDtoRegisters) {
        this.userDtoRegisters = userDtoRegisters;
    }

    public UserDtoRegisterWrapper() {
    }
}
