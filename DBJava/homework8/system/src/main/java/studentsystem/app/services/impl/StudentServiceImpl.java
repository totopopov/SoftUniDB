package studentsystem.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsystem.app.models.Student;
import studentsystem.app.repository.StudentRepository;
import studentsystem.app.services.interfaces.StudentService;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 26.7.2017 г. at 20:09.
 */

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void register(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public List<Object[]> findStundentNameAndHomeworkInfo() {
        return this.studentRepository.findStundentNameAndHomeworkInfo();
    }
}
