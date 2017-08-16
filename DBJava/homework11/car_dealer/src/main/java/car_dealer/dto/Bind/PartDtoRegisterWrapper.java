package car_dealer.dto.Bind;

import car_dealer.dto.View.SupplierViewBasic;
import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 22:10.
 */

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartDtoRegisterWrapper {

    @XmlElement(name = "part")
    private List<PartDtoRegister> parts;

    public List<PartDtoRegister> getParts() {
        return parts;
    }

    public void setParts(List<PartDtoRegister> parts) {
        this.parts = parts;
    }
}
