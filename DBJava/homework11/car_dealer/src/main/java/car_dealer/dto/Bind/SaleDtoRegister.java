package car_dealer.dto.Bind;

import car_dealer.app.entities.Car;
import car_dealer.app.entities.Customer;
import car_dealer.dto.View.CarDtoViewBasic;
import car_dealer.dto.View.CustomerDtoViewBasic;

import java.math.BigDecimal;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 23:36.
 */

public class SaleDtoRegister {
    private CarDtoViewBasic car;
    private CustomerDtoViewBasic customer;

    private Long id;

    private BigDecimal discount;

    public SaleDtoRegister() {
    }

    public CarDtoViewBasic getCar() {
        return car;
    }

    public void setCar(CarDtoViewBasic car) {
        this.car = car;
    }

    public CustomerDtoViewBasic getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDtoViewBasic customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
