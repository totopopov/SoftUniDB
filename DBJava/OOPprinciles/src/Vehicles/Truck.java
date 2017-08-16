package Vehicles;

import java.text.DecimalFormat;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 18:42.
 */
public class Truck extends Vehicle {

    private  double distance;

    public Truck(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, 1.6+litersPerKm);
        this.distance=0;
    }


    @Override
    public String drive(double km) {
        if (km*this.getLitersPerKm()>this.getFuelQuantity()){
            return "Truck needs refueling";
        }
            this.distance+=km;
        super.burnFuel(km*this.getLitersPerKm());
        return String.format("Truck travelled %s km", new DecimalFormat("#.########################").format(km));
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters*0.95);
    }



}
