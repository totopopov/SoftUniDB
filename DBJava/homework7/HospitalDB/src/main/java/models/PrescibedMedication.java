package models;

import javax.persistence.*;

/**
 * Created by Todor Popov using Lenovo on 23.7.2017 г. at 0:32.
 */

@Entity
@Table(name = "prescribed_medications")
public class PrescibedMedication {



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
        if (name.length()>255){
            throw new IllegalArgumentException("Mediation Name too long");
        }
        this.name = name;
    }
}
