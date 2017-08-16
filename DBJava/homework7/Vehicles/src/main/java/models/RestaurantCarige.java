package models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 22:13.
 */
@Entity
@DiscriminatorValue("restaurant")
public class RestaurantCarige extends Carige {
    private Integer tablesCount;

    @Column(name = "tables_count")
    public Integer getTablesCount() {
        return tablesCount;
    }

    public void setTablesCount(Integer tablesCount) {
        this.tablesCount = tablesCount;
    }
}
