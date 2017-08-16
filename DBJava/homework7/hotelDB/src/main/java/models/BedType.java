package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Todor Popov using Lenovo on 22.7.2017 г. at 2:32.
 */

@Entity
@Table(name = "bed_types")
public class BedType {

    private String bedType;
    private String notes;

    @Id
    @Column(name = "bed_type")
    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
