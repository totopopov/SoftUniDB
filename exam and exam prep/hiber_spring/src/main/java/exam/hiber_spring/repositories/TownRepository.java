package exam.hiber_spring.repositories;


import exam.hiber_spring.entitites.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
    Town findByName(String name);

    @Query(value = "SELECT t.name,t.population, pb.payers FROM towns AS t \n" +
            "LEFT JOIN \n" +
            "(SELECT b.town_id, SUM(p.clients) AS payers FROM branch AS b \n" +
            "LEFT JOIN products AS p ON p.branch_id=b.id\n" +
            "GROUP BY b.town_id) AS pb ON pb.town_id=t.id\n" +
            "ORDER BY pb.payers DESC ",nativeQuery = true)
    List<Object[]> townsData();
}
