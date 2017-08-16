package studentsystem.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsystem.app.models.Course;
import studentsystem.app.repository.CourseRepository;
import studentsystem.app.services.interfaces.CourseService;

import java.util.Date;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 26.7.2017 г. at 20:16.
 */

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void register(Course course) {
        this.courseRepository.save(course);
    }

    @Override
    public List<Object[]> findWithInformationForResources() {
        return this.courseRepository.findWithInformationForResources();
    }

    @Override
    public List<Object[]> fetchCoursesWIthMoreThan5Resourse(int size) {
        return this.courseRepository.fetchCoursesWIthMoreThan5Resourse(size);
    }

    @Override
    public List<Object[]> takeCoursesActiveOnGivenDate(Date date) {
        return this.courseRepository.takeCoursesActiveOnGivenDate(date);
    }


}
