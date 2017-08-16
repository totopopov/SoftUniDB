package car_dealer.app.repositories;

import car_dealer.app.entities.Customer;
import car_dealer.app.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = "SELECT c.name, COUNT(s.car_id) AS car , SUM(pr.price*(1-s.discount/100) ) AS money FROM sales AS s \n" +
            "\n" +
            "INNER JOIN customers AS c ON c.id=s.customer_id\n" +
            "\n" +
            "INNER JOIN \n" +
            "\n" +
            "(SELECT  c.id, SUM(p.price) AS price FROM cars AS c \n" +
            "INNER JOIN parts_cars as pc ON c.id=pc.car_id\n" +
            "INNER JOIN parts as p ON p.id=pc.part_id\n" +
            "GROUP BY c.id) as pr ON pr.id=s.car_id\n" +
            "\n" +
            "GROUP BY c.id\n" +
            "\n" +
            "ORDER BY money DESC,car DESC",nativeQuery = true )
    List<Object[]> findCustomersWithCars();




   @Query(value = "SELECT c.make, c.model, c.travel_distance, cu.name, s.discount,  SUM(p.price), ((SUM(p.price))*(1-s.discount/100)) AS `price` FROM cars AS c \n" +
           "INNER JOIN parts_cars as pc ON c.id=pc.car_id\n" +
           "INNER JOIN parts as p ON p.id=pc.part_id\n" +
           "INNER JOIN sales AS s ON s.car_id=c.id\n" +
           "INNER JOIN customers AS cu ON cu.id=s.customer_id \n" +
           "GROUP BY c.id", nativeQuery = true)
    List<Object[]> findSaleDetailedInfo();




}
