package studentsystem.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import studentsystem.app.models.Course;

import java.util.Date;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 26.7.2017 г. at 20:03.
 */


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c.name,c.description,r.name,r.URL,r.typeOfResouece FROM Course AS c " +
            "INNER JOIN c.resources r " +
            "ORDER BY c.startDate ASC, c.endDate DESC ")
    List<Object[]> findWithInformationForResources();


    @Query("SELECT c.name, c.resources.size FROM Course AS c WHERE c.resources.size>:size " +
            "ORDER BY c.resources.size DESC, c.startDate DESC ")
    List<Object[]> fetchCoursesWIthMoreThan5Resourse(@Param("size") int size);


    @Query("SELECT c.name,c.startDate, c.endDate ,c.students.size, DATEDIFF(c.endDate,c.startDate) FROM Course AS c " +
            "WHERE c.startDate < :date AND c.endDate > :date " +
            "GROUP BY c " +
            "ORDER BY c.students.size DESC , DATEDIFF(c.endDate,c.startDate) DESC")
    List<Object[]> takeCoursesActiveOnGivenDate(@Param("date") Date size);
}
