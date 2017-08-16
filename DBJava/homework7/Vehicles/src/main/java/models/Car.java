package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 22:05.
 */
@Entity
@Table(name = "car")
public class Car extends MotorVehicle {
    private Integer numberOfDoors;
    private Boolean insurance;

    @Column(name = "number_of_doors")
    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Boolean getInsurance() {
        return insurance;
    }

    public void setInsurance(Boolean insurance) {
        this.insurance = insurance;
    }
}
