package models;

import javax.persistence.*;

/**
 * Created by Todor Popov using Lenovo on 23.7.2017 г. at 2:30.
 */

@Entity
@Table(name = "competition_type")
public class CompetitionType {

    private Long id;
    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
