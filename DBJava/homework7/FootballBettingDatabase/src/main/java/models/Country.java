package models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 23.7.2017 г. at 2:09.
 */

@Entity
@Table(name = "countries")
public class Country {

    private Long id;
    private String name;
    private Set<Continet> continets;
    private Set<Town> towns;

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
    @ManyToMany
    @JoinTable(name = "countries_continets",joinColumns = @JoinColumn(name = "country_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "continent_id",referencedColumnName = "id"))
    public Set<Continet> getContinets() {
        return continets;
    }

    public void setContinets(Set<Continet> continets) {
        this.continets = continets;
    }

    @OneToMany(mappedBy = "country",targetEntity = Town.class)
    public Set<Town> getTowns() {
        return towns;
    }

    public void setTowns(Set<Town> towns) {
        this.towns = towns;
    }
}
