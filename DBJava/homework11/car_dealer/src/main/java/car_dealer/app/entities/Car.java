package car_dealer.app.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 20:48.
 */

@Entity
@Table(name = "cars")
public class Car {

    private Long id;

    private String make;

    private String model;

    private BigInteger travelledDistance;

    private Set<Part> parts;

    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(nullable = false)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "travel_distance", nullable = false, columnDefinition = "BIGINT UNSIGNED")
    public BigInteger getTravelDistance() {
        return travelledDistance;
    }

    public void setTravelDistance(BigInteger travelDistance) {
        this.travelledDistance = travelDistance;
    }

    @ManyToMany()
    @JoinTable(name = "parts_cars", inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id"),
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"))
    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
