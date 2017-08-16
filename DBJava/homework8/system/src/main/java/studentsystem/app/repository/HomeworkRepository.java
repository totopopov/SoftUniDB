package studentsystem.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentsystem.app.models.Homework;


/**
 * Created by Todor Popov using Lenovo on 26.7.2017 г. at 20:03.
 */


@Repository
public interface HomeworkRepository extends JpaRepository<Homework,Long> {
}
