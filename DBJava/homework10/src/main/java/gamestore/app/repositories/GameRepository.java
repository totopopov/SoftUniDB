package gamestore.app.repositories;

import gamestore.app.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllByTitle(String title);

    @Query("SELECT g.title FROM User AS u INNER JOIN u.boughtGames AS g WHERE u.id=:id")
    List<String> getAllOwnedGames(@Param("id") Long id);
}
