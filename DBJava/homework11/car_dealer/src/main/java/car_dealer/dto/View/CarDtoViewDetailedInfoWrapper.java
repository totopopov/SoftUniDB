package car_dealer.dto.View;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 9.8.2017 г. at 22:21.
 */

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarDtoViewDetailedInfoWrapper {

    @XmlElement(name = "car")
    List<CarDtoViewDetailedInfo> cars;

    public List<CarDtoViewDetailedInfo> getCars() {
        return cars;
    }

    public void setCars(List<CarDtoViewDetailedInfo> cars) {
        this.cars = cars;
    }
}
