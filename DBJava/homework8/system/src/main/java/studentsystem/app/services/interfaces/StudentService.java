package studentsystem.app.services.interfaces;

import org.springframework.stereotype.Service;
import studentsystem.app.models.Student;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 26.7.2017 г. at 20:06.
 */

public interface StudentService {
    void register(Student student);
    List<Object[]> findStundentNameAndHomeworkInfo();
}
