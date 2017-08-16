package studentsystem.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsystem.app.models.Homework;
import studentsystem.app.models.Resource;
import studentsystem.app.repository.HomeworkRepository;
import studentsystem.app.services.interfaces.HomeworkService;

/**
 * Created by Todor Popov using Lenovo on 26.7.2017 г. at 20:17.
 */

@Service
public class HomeworkServiceImpl implements HomeworkService {

    private final HomeworkRepository homeworkRepository;

    @Autowired
    public HomeworkServiceImpl(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    @Override
    public void register(Homework homework) {
        this.homeworkRepository.save(homework);
    }
}
