package carShop;

/**
 * Created by Todor Popov using Lenovo on 3.7.2017 г. at 16:45.
 */
public class Audi implements Rentable {
    private String model;
    private String color;
    private int horsepower;
    private int minRentDay;
    private double pricePerDay;

    public Audi(String model, String color, int horsepower, int minRentDay, double pricePerDay) {
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public int getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public double getPricePerDay() {
        return this.pricePerDay;
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
}
