package car_dealer.dto.Bind;

import car_dealer.dto.View.PartDtoViewBasic;
import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 22:21.
 */

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarDtoRegisterWrapper {

    @XmlElement(name = "car")
    List<CarDtoRegister> cars;

    public List<CarDtoRegister> getCars() {
        return cars;
    }

    public void setCars(List<CarDtoRegister> cars) {
        this.cars = cars;
    }
}
