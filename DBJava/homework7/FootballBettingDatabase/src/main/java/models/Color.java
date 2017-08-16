package models;

import javax.persistence.*;

/**
 * Created by Todor Popov using Lenovo on 23.7.2017 г. at 2:20.
 */

@Entity
@Table(name = "colors")
public class Color {

    private Long id;
    private String name;

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
}
