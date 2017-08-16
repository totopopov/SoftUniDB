package foto.repositories;

import foto.entities.BasicCamer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicCamerRepository extends JpaRepository<BasicCamer, Long> {
}
