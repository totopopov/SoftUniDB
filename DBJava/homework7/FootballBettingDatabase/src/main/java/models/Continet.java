package models;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 23.7.2017 г. at 2:07.
 */

@Entity
@Table(name = "continets")
public class Continet {


    private  Long id;
    private String name;
    private Set<Country> countries;


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

    @ManyToMany(mappedBy = "continets",targetEntity = Country.class)

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }
}
