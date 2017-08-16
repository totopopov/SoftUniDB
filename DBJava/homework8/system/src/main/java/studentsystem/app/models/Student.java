package studentsystem.app.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 26.7.2017 г. at 19:15.
 */

@Entity
@Table(name = "students")
public class Student {


    private Long id;
    private String name;
    private String phoneNumber;
    private Date registrationDate;
    private Date birthDate;
    private Set<Course> courses;
    private Homework homework;


    public Student() {
    }

    public Student(String name, String phoneNumber, Date registrationDate, Date birthDate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
        this.birthDate = birthDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "phone_number",nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "registration_date",nullable = false)
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Column(name = "birth_date",nullable = false)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @ManyToMany(mappedBy = "students",targetEntity = Course.class)
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @OneToOne(mappedBy = "student",fetch = FetchType.EAGER)
    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }
}
