package Vehicles;

/**
 * Created by Todor Popov using Lenovo on 5.7.2017 г. at 17:18.
 */
public interface Drivable {
    String drive(double km);
    void refuel(double liters);
    double getFuelQuantity();
}
