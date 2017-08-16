package exam.hiber_spring.entitites;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 9:17.
 */

@Entity
@Table(name = "employee_card")
public class EmployeeCard {

    private Integer id;

    private String number;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "number",unique = true)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
