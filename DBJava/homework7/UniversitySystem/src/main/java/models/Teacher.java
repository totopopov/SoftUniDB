package models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 20:59.
 */
@Entity
//@DiscriminatorValue("teacher")
@Table(name = "teachers")
@PrimaryKeyJoinColumn(name = "id")
public class Teacher extends Person {

    private String email;
    private String salaryPerHour;
    private Set<Course> courses;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "salary_per_hour")
    public String getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(String salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    @OneToMany(mappedBy = "teacher",targetEntity = Course.class)
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
