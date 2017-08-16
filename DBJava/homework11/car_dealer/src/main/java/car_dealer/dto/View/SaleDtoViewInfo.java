package car_dealer.dto.View;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

/**
 * Created by Todor Popov using Lenovo on 9.8.2017 г. at 23:22.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class SaleDtoViewInfo {

    @XmlAttribute(name = "full-name")
    private String name;
    @XmlAttribute(name = "bought-cars")
    private Integer cars;

    @XmlAttribute(name = "spent-money")
    private BigDecimal money;

    public SaleDtoViewInfo() {
    }

    public SaleDtoViewInfo(String name, Integer cars, BigDecimal money) {
        this.name = name;
        this.cars = cars;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCars() {
        return cars;
    }

    public void setCars(Integer cars) {
        this.cars = cars;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
