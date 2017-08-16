package models;

import javax.persistence.*;

/**
 * Created by Todor Popov using Lenovo on 23.7.2017 г. at 0:29.
 */

@Entity
@Table(name = "diagnoses")
public class Diagnose {

    private Long id;
    private String name;
    private String comments;



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
            throw new IllegalArgumentException("Name too long");
        }
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        if (comments.length()>255){
            throw new IllegalArgumentException("Comments too long, try to shorten or just split it into 2");
        }
        this.comments = comments;
    }
}
