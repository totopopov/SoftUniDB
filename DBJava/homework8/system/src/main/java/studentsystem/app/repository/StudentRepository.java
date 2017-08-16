package studentsystem.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import studentsystem.app.models.Student;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 26.7.2017 г. at 20:03.
 */


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


    @Query("SELECT s.name, s.homework.content,s.homework.contentType FROM Student AS s ")
    List<Object[]> findStundentNameAndHomeworkInfo();


}
