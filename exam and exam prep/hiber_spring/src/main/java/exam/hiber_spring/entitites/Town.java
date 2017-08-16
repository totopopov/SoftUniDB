package exam.hiber_spring.entitites;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 9:18.
 */

@Entity
@Table(name = "towns")
public class Town {

    private Integer id;

    private String name;

    private Integer population;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Column(name = "population",nullable = false)
    public Integer getPopulation() {
        return population;
    }


    public void setPopulation(Integer population) {
        this.population = population;
    }
}
