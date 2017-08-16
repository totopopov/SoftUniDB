package models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 22:08.
 */

@Entity
@Table(name = "trans")
public class Train extends MotorVehicle {
    private Locomotive locomotive;
    private Set<Carige> carige;
    private Integer carigeNumber;

    @OneToOne
    @JoinColumn(name = "locomotive_id",referencedColumnName = "id")
    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    @OneToMany(mappedBy = "train")
    public Set<Carige> getCarige() {
        return carige;
    }

    public void setCarige(Set<Carige> carige) {
        this.carige = carige;
    }

    public Integer getCarigeNumber() {
        return carigeNumber;
    }

    public void setCarigeNumber(Integer carigeNumber) {
        this.carigeNumber = carigeNumber;
    }
}
