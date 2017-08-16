package Vehicles;

import java.text.DecimalFormat;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 18:39.
 */
public class Car extends Vehicle {

    private  double distance;

    public Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm+0.9);
        this.distance=0;
    }


    @Override
    public String drive(double km) {
        if (km*this.getLitersPerKm()>this.getFuelQuantity()){
            return "Car needs refueling";
        }
        this.distance+=km;
        super.burnFuel(km*this.getLitersPerKm());
        return String.format("Car travelled %s km", new DecimalFormat("#.########################").format(km));
    }


}
