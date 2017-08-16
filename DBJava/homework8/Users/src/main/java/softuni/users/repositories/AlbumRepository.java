package softuni.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.users.entities.Album;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
