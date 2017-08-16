package exam.hiber_spring.entitites;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 9:20.
 */

@Entity
@Table(name = "branch")
public class Branch {

    private Integer id;

    private String name;

    private Town town;


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
    @ManyToOne
    @JoinColumn(name = "town_id",referencedColumnName = "id",nullable = false)
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
