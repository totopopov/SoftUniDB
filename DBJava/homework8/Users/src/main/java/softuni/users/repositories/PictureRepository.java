package softuni.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.users.entities.Picture;


@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
}
