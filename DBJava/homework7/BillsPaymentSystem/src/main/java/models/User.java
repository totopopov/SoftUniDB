package models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 20:06.
 */

@Entity
@Table(name = "users")
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<BillingDetail> billingDetails;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "user",targetEntity = BillingDetail.class)
    public Set<BillingDetail> getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(Set<BillingDetail> billingDetails) {
        this.billingDetails = billingDetails;
    }
}
