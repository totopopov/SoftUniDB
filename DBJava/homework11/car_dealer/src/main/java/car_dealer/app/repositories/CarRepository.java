package car_dealer.app.repositories;

import car_dealer.app.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByMakeEqualsOrderByModelAscTravelDistanceDesc(String make);
    List<Car> findAll();
}
