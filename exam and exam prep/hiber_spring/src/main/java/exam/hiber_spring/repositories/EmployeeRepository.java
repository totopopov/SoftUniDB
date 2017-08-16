package exam.hiber_spring.repositories;

import exam.hiber_spring.entitites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT DISTINCT Concat(e.first_name,' ',e.last_name),e.position, ec.number  FROM employees AS e \n" +
            "INNER JOIN branch AS b ON b.id=e.branch_id\n" +
            "INNER JOIN products AS p ON p.branch_id=b.id\n" +
            "INNER JOIN employee_card AS ec ON ec.id=e.card_id\n" +
            "\n" +
            "ORDER BY e.first_name ASC,e.last_name ASC,LENGTH(e.position) DESC ", nativeQuery = true)
    List<Object[]> employeesInBranchWithProducts();
}
