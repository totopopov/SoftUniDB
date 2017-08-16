package exam.hiber_spring.repositories;

import exam.hiber_spring.entitites.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
    Branch findByName(String name);

    @Query(value = "SELECT b.name, t.name AS town, SUM(p.clients)\n" +
            "FROM branch AS b\n" +
            "LEFT JOIN products AS p ON p.branch_id=b.id\n" +
            "INNER JOIN towns AS t ON b.town_id=t.id\n" +
            "GROUP BY b.name, t.name\n" +
            "ORDER BY SUM(p.clients) DESC, LENGTH(b.name)",nativeQuery = true)
    List<Object[]> branchRawInfo();
}
