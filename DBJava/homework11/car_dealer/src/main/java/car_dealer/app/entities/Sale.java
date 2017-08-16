package car_dealer.app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 21:14.
 */

@Entity
@IdClass(value = Sale.SaleId.class)
@Table(name = "sales")
public class Sale {
    private Long carId;
    private Long customerId;

    private Car car;
    private Customer customer;

    private Long id;

    private BigDecimal discount;

    public Sale() {
    }

    @Id
    @Column(name = "car_id")
    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    @Id
    @Column(name = "customer_id")
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @MapsId("car_id")
    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @MapsId("customer_id")
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
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

    static class SaleId implements Serializable {
        private Long carId;        //same type as the Id in the GAME class
        private Long customerId;      //same type as the Id in the GAME class

        public SaleId() {
        }

        public SaleId(Long carId, Long customerId) {
            this.carId = carId;
            this.customerId = customerId;
        }

        public Long getCarId() {
            return carId;
        }

        public void setCarId(Long carId) {
            this.carId = carId;
        }

        public Long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Long customerId) {
            this.customerId = customerId;
        }
    }
}
