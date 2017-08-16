package car_dealer.dto.View;

import javax.validation.constraints.Max;
import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 9.8.2017 г. at 22:21.
 */

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarDtoViewInfoWrapper {

    @XmlElement(name = "car")
    private List<CarDtoViewInfo> cars;

    public List<CarDtoViewInfo> getCars() {
        return cars;
    }

    public void setCars(List<CarDtoViewInfo> cars) {
        this.cars = cars;
    }
}
