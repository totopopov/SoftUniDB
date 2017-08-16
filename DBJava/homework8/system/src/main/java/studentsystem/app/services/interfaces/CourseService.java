package studentsystem.app.services.interfaces;

import org.springframework.data.repository.query.Param;
import studentsystem.app.models.Course;

import java.util.Date;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 26.7.2017 г. at 20:06.
 */

public interface CourseService {
    void register(Course course);

    List<Object[]> findWithInformationForResources();

    List<Object[]> fetchCoursesWIthMoreThan5Resourse(int size);

    List<Object[]> takeCoursesActiveOnGivenDate(Date size);
}
