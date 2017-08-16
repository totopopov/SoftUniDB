package exam.hiber_spring.entitites;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 9:15.
 */

@Entity
@Table(name = "employees")
public class Employee {

    private Integer id;

    private String firstName;

    private String lastName;

    private String position;

    private EmployeeCard card;

    private Branch branch;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "first_name",nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Column(name = "last_name",nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    @Column(name = "position",nullable = false)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @NotNull
    @OneToOne
    @JoinColumn(name = "card_id",referencedColumnName = "id",unique = true,nullable = false)
    public EmployeeCard getCard() {
        return card;
    }

    public void setCard(EmployeeCard card) {
        this.card = card;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "branch_id",referencedColumnName = "id",nullable = false)
    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
