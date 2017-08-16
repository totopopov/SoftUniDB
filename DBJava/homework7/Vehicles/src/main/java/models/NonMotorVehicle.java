package models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 22:00.
 */
@Entity
@Table(name = "non_motor_vehicles")
public abstract class NonMotorVehicle extends Vehicle{

}
