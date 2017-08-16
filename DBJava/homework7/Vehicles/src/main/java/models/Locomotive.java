package models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 22:07.
 */

@Entity
@Table(name ="locomotive")
public class Locomotive extends MotorVehicle {

    private Double power;
    private Train train;


    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    @OneToOne(mappedBy = "locomotive")
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
