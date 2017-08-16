package models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Todor Popov using Lenovo on 23.7.2017 г. at 0:25.
 */

@Entity
@Table(name = "visitations")
public class Visitation {

    private Long id;
    private Date date;
    private String comments;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
