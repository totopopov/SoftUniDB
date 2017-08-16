package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 22:23.
 */

@Entity
@Table(name = "planes")
public class Plane extends MotorVehicle{
    private String airlineOwner;
    private String color;
    private Integer capacity;

    @Column(name = "airline_owner")
    public String getAirlineOwner() {
        return airlineOwner;
    }

    public void setAirlineOwner(String airlineOwner) {
        this.airlineOwner = airlineOwner;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
