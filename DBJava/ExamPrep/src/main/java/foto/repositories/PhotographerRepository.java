package foto.repositories;

import foto.entities.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer, Long> {

    List<Photographer> findAllByOrderByFirstNameAscLastNameDesc();

    List<Photographer> findAllByFirstNameAndLastName(String firstName, String lastName);
}
