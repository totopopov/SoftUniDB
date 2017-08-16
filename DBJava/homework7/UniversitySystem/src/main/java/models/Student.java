package models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 20:56.
 */
@Entity
//@DiscriminatorValue("sutdent")
@Table(name = "students")
@PrimaryKeyJoinColumn(name = "id")
public class Student extends Person {

    private Double averageGrade;
    private Double attendance;
    private Set<Course> courses;

    @Column(name = "average_grade")
    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }


    public Double getAttendance() {
        return attendance;
    }

    public void setAttendance(Double attendance) {
        this.attendance = attendance;
    }

    @ManyToMany
    @JoinTable(name = "student_courses",joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id"))
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
