package carShop;

import java.io.Serializable;

/**
 * Created by Todor Popov using Lenovo on 3.7.2017 г. at 16:21.
 */
public class Seat implements Serializable, Sellable{

    private String model;
    private String color;
    private int horsepower;
    private String countryProduced;
    private double price;

    public Seat(String model, String color, int horsepower, String countryProduced,double price) {
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
        this.countryProduced = countryProduced;
        this.price=price;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsepower;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %s tires",this.getModel(),this.countryProduced,Car.Tires);
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
