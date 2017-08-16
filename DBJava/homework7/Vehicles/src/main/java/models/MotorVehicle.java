package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 22:02.
 */
@Entity
@Table(name = "motor_vehicles")
public abstract class MotorVehicle extends Vehicle {

    private Integer engineNumber;
    private String engineType;
    private Double tankCapacity;

    @Column(name = "engine_number")
    public Integer getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(Integer engineNumber) {
        this.engineNumber = engineNumber;
    }

    @Column(name = "engine_type")
    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Column(name = "tank_capacity")
    public Double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}
