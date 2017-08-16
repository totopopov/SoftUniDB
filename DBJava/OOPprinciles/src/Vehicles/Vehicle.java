package Vehicles;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 18:39.
 */
public abstract class Vehicle implements Drivable {

    private double fuelQuantity;
    private double litersPerKm;


    public Vehicle(double fuelQuantity, double litersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
    }

    @Override
    public final double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public final double getLitersPerKm() {
        return this.litersPerKm;
    }

    @Override
    public void refuel(double liters) {
        this.fuelQuantity+=liters;
    }

    protected final void burnFuel(double fuelQuantity) {
        this.fuelQuantity -= fuelQuantity;
    }
}
