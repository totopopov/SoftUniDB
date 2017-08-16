package models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 21:05.
 */

@Entity
@Table(name = "courses")
public class Course {

    private Long id;
    private String nameDescription;
    private Date startDate;
    private Date endDate;
    private Integer credits;
    private Teacher teacher;
    private Set<Student> students;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name_description")
    public String getNameDescription() {
        return nameDescription;
    }

    public void setNameDescription(String nameDescription) {
        this.nameDescription = nameDescription;
    }

    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @ManyToOne()
    @JoinColumn(name = "teacher_id",referencedColumnName = "id")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @ManyToMany(mappedBy = "courses")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> studentSet) {
        this.students = studentSet;
    }
}
