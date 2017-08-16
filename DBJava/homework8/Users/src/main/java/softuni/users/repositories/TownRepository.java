package softuni.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.users.entities.Town;


@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
}
