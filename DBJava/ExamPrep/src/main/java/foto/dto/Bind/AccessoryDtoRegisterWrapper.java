package foto.dto.Bind;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 12.8.2017 г. at 20:09.
 */

@XmlRootElement(name = "accessories")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoryDtoRegisterWrapper {

    @XmlElement(name = "accessory")
    List<AccessoryDtoRegister> accessries;


    public List<AccessoryDtoRegister> getAccessries() {
        return accessries;
    }

    public void setAccessries(List<AccessoryDtoRegister> accessries) {
        this.accessries = accessries;
    }
}
