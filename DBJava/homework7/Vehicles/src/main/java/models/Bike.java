package models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 22:01.
 */

@Entity
@Table(name = "bikes")
public class Bike extends NonMotorVehicle{
    private String color;
    private Integer shifts;
}
