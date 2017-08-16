package gamestore.app.services;

import gamestore.app.entities.Game;
import gamestore.app.entities.models.bindingModels.GameDtoAdd;
import gamestore.app.entities.models.bindingModels.GameDtoEdit;
import gamestore.app.entities.models.viewModels.GameDtoDetailedInfo;
import gamestore.app.entities.models.viewModels.GameDtoInfo;
import gamestore.app.entities.models.viewModels.GameDtoShopingCart;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameService {

    List<Game> findAll();

    List<GameDtoInfo> findInfoForAll();


    GameDtoEdit findById(Long id);

    Game create(Game game);

    List<Game> multipleCreate(Iterable<Game> games);

    String deleteById(Long id);

    Boolean addGame(GameDtoAdd game);

    Boolean edit(GameDtoEdit game);

    List<GameDtoDetailedInfo> findByTittle(String title);

    List<String> getAllOwnedGames(@Param("id") Long id);

    //    List<GameDtoShopingCart> findByTittleForCart(String title);
    List<Game> findByTittleForCart(String title);
}
