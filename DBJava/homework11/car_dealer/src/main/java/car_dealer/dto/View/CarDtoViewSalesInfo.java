package car_dealer.dto.View;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 9.8.2017 г. at 22:21.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class CarDtoViewSalesInfo {

    @XmlAttribute(name = "make")
    private String make;

    @XmlAttribute(name = "model")
    private String model;

    @XmlAttribute(name = "travelled-distance")
    private BigInteger travelledDistance;


    public CarDtoViewSalesInfo() {
    }

    public CarDtoViewSalesInfo(String make, String model, BigInteger travelledDistance) {
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigInteger getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(BigInteger travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

}
