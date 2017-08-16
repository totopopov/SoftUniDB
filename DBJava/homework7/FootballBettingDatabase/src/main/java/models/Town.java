package models;

import javax.persistence.*;

/**
 * Created by Todor Popov using Lenovo on 23.7.2017 г. at 2:17.
 */
@Entity
@Table(name = "towns")
public class Town {

    private Long id;
    private String name;
    private Country country;


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

    @ManyToOne
    @JoinColumn(name = "country_id",referencedColumnName = "id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
