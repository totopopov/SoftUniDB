package foto.dto.Bind;


import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 12.8.2017 г. at 20:27.
 */

@XmlRootElement(name = "workshops")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopDtoRegisterWrapper {

    @XmlElement(name = "workshop")
    private List<WorkshopDtoRegister> workshops;

    public List<WorkshopDtoRegister> getWorkshops() {
        return workshops;
    }

    public void setWorkshops(List<WorkshopDtoRegister> workshops) {
        this.workshops = workshops;
    }
}
