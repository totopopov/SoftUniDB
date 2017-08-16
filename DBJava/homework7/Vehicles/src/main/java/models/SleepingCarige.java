package models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 22:14.
 */

@Entity
@DiscriminatorValue("sleeping")
public class SleepingCarige extends Carige{
    private Integer bedsCount;

    @Column(name = "beds_count")
    public Integer getBedsCount() {
        return bedsCount;
    }

    public void setBedsCount(Integer bedsCount) {
        this.bedsCount = bedsCount;
    }
}
