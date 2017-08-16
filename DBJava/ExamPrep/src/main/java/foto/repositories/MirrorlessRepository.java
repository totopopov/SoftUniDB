package foto.repositories;

import foto.entities.Mirrorless;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MirrorlessRepository extends JpaRepository<Mirrorless, Long> {
}
