package car_dealer.dto.Bind;

import car_dealer.dto.View.PartDtoViewBasic;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 22:21.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDtoRegister {

    @Expose
    @XmlAttribute(name = "name")
    private String name;

    @Expose
    @XmlElement(name = "birth-date")
    private Date birthDate;

    @Expose
    @SerializedName("isYoungDriver")
    @XmlElement(name = "is-young-driver")
    private Boolean YoungDriver;

    public CustomerDtoRegister() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        birthDate = birthDate;
    }

    public Boolean getYoungDriver() {
        return YoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        YoungDriver = youngDriver;
    }
}
