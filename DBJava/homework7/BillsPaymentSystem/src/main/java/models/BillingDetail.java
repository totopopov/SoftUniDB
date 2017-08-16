package models;

import javax.persistence.*;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 20:08.
 */

@Entity
@Table(name = "billinng_details")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)    for single inheritance
//@DiscriminatorColumn(name = "tpye",discriminatorType = DiscriminatorType.STRING)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)   for table per class inheritance
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetail {

    private String number;
    private String Owner;
    private User user;


    @Id
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
