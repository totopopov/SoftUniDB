package car_dealer.app.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 20:53.
 */

@Entity
@Table(name = "customers")
public class Customer {

    private Long id;

    private String name;

    private Date birthDate;

    private Boolean YoungDriver;

    public Customer() {
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false,name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }




    @Column(name = "is_young_driver",nullable = false)
    public Boolean getYoungDriver() {
        return YoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        YoungDriver = youngDriver;
    }
}
