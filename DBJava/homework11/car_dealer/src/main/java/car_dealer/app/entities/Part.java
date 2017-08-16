package car_dealer.app.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 21:05.
 */

@Entity
@Table(name = "parts")
public class Part {

    private Long id;

    private String name;

    private BigDecimal price;

    private Long quantity;

    private Supplier supplier;

    private Set<Car> cars;

    public Part() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    @JoinColumn(name = "supplier_id",referencedColumnName = "id")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @ManyToMany(mappedBy ="parts")
    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
