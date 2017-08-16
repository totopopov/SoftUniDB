package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 22.7.2017 г. at 2:26.
 */
@Entity
@Table(name = "customers")
public class Customer {


    private String accountNumer;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emergencyName;
    private String emergencyNumber;
    private String notes;
    private Set<Occupancy> occupancies;
    private Set<Payment> payments;



    @Id
    public String getAccountNumer() {
        return accountNumer;
    }

    public void setAccountNumer(String accountNumer) {
        this.accountNumer = accountNumer;
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

    @Column(name = "emergency_name")
    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    @Column(name = "emergency_number")
    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @OneToMany(mappedBy = "customer",targetEntity = Occupancy.class,cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    public Set<Occupancy> getOccupancies() {
        return occupancies;
    }

    public void setOccupancies(Set<Occupancy> occupancies) {
        this.occupancies = occupancies;
    }

    @OneToMany(mappedBy = "customer",targetEntity = Payment.class,cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }
}
