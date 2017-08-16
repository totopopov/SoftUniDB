package studentsystem.app.models;



import javax.persistence.*;
import java.util.Date;

/**
 * Created by Todor Popov using Lenovo on 26.7.2017 г. at 19:35.
 */

@Entity
public class Homework {

    private Long id;
    private String content;
    private String contentType;
    private Date submissionDate;
    private Course course;
    private Student student;

    public Homework() {
    }

    public Homework(String content, String contentType, Date submissionDate) {
        this.content = content;
        this.contentType = contentType;
        this.submissionDate = submissionDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY      )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

    @Column(nullable =false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(nullable =false,name = "content_type")
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Column(nullable =false,name = "submission_date")
    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    @ManyToOne
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @OneToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
