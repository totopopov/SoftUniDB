package car_dealer.dto.View;

import car_dealer.app.entities.Part;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 9.8.2017 г. at 22:21.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class CarDtoViewDetailedInfo {

    @XmlAttribute(name = "make")
    private String make;

    @XmlAttribute(name = "model")
    private String model;

    @XmlAttribute(name = "travelled-distance")
    private BigInteger travelledDistance;

    @XmlElementWrapper(name = "parts")
    @XmlElement(name = "part")
    private Set<PartDtoViewDetailed> parts;


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

    public Set<PartDtoViewDetailed> getParts() {
        return parts;
    }

    public void setParts(Set<PartDtoViewDetailed> parts) {
        this.parts = parts;
    }
}
