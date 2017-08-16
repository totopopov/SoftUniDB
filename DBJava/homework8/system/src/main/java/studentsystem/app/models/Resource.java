package studentsystem.app.models;

import javax.persistence.*;

/**
 * Created by Todor Popov using Lenovo on 26.7.2017 г. at 19:32.
 */

@Entity
@Table(name = "resources")
public class Resource {

    private Long id;
    private String name;
    private String typeOfResouece;
    private String URL;
    private Course course;

    public Resource() {
    }

    public Resource(String name, String typeOfResouece, String URL) {
        this.name = name;
        this.typeOfResouece = typeOfResouece;
        this.URL = URL;
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

    @Column(nullable = false,name = "type_of_resource")
    public String getTypeOfResouece() {
        return typeOfResouece;
    }

    public void setTypeOfResouece(String typeOfResouece) {
        this.typeOfResouece = typeOfResouece;
    }

    @Column(nullable = false)
    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @ManyToOne()
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
