package exam.hiber_spring.repositories;

import exam.hiber_spring.entitites.EmployeeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCardRepository extends JpaRepository<EmployeeCard, Long> {
    EmployeeCard findByNumber(String number);


    @Query(value = "SELECT ec.* FROM employee_card AS ec\n" +
            "\n" +
            "LEFT JOIN employees AS e ON e.card_id=ec.id\n" +
            "\n" +
            "WHERE e.id IS NUll\n" +
            "\n" +
            "ORDER BY ec.id", nativeQuery = true)
    List<EmployeeCard> findAllFree();
}
