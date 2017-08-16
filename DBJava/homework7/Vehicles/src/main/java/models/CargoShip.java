package models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 22:29.
 */
@Entity
@Table(name = "cargo_ship")
public class CargoShip extends Ship {
    private Double maxLoadKg;

    @Column(name = "max_load_kg")
    public Double getMaxLoadKg() {
        return maxLoadKg;
    }

    public void setMaxLoadKg(Double maxLoadKg) {
        this.maxLoadKg = maxLoadKg;
    }
}
