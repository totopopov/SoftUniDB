package models;

import org.hibernate.annotations.DiscriminatorFormula;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 20:33.
 */

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;


    @Id
    //  @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @GeneratedValue(strategy = GenerationType.TABLE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
