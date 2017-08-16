package models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 22:12.
 */

@Entity
@DiscriminatorValue("passanger")
public class PassengerCarige extends Carige {
    private Integer standingSeats;

    @Column(name = "standing_seats")
    public Integer getStandingSeats() {
        return standingSeats;
    }

    public void setStandingSeats(Integer standingSeats) {
        this.standingSeats = standingSeats;
    }
}
