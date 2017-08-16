package studentsystem.app.models;



import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 26.7.2017 г. at 19:20.
 */

@Entity
@Table(name = "courses")
public class Course {

    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private BigDecimal price;
    private Set<Student> students;
    private Set<Homework> homeworks;
    private Set<Resource> resources;

    public Course() {
    }

    public Course(String name, String description, Date startDate, Date endDate, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
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

    @Column()
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false, name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(nullable = false, name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToMany()
    @JoinTable(name = "courses_students",
            joinColumns = @JoinColumn(name ="course_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"))
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "course")
    public Set<Homework> getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(Set<Homework> homeworks) {
        this.homeworks = homeworks;
    }

    @OneToMany(mappedBy = "course",targetEntity = Resource.class,fetch = FetchType.LAZY)
    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }
}
