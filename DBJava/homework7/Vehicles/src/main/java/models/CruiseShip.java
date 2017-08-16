package models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 22:30.
 */

@Entity
@Table(name = "cruise_ship")
public class CruiseShip extends Ship {
    private Long passsangerCapacity;

    @Column(name = "passangers_capacity")
    public Long getPasssangerCapacity() {
        return passsangerCapacity;
    }

    public void setPasssangerCapacity(Long passsangerCapacity) {
        this.passsangerCapacity = passsangerCapacity;
    }
}
