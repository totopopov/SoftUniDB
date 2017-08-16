package car_dealer.dto.Bind;

import car_dealer.dto.View.PartDtoViewBasic;
import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigInteger;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 22:21.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class CarDtoRegister {

    @Expose
    @XmlElement(name = "make")
    private String make;


    @Expose
    @XmlElement(name = "model")
    private String model;

    @Expose
    @XmlElement(name = "travelled-distance")
    private BigInteger travelledDistance;

    @XmlTransient
    private Set<PartDtoViewBasic> parts;

    public CarDtoRegister() {
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

    public BigInteger getTravelDistance() {
        return travelledDistance;
    }

    public void setTravelDistance(BigInteger travelDistance) {
        this.travelledDistance = travelDistance;
    }

    public Set<PartDtoViewBasic> getParts() {
        return parts;
    }

    public void setParts(Set<PartDtoViewBasic> parts) {
        this.parts = parts;
    }
}
