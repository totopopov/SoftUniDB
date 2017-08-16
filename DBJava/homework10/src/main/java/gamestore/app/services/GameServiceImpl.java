package gamestore.app.services;

import gamestore.app.entities.Game;
import gamestore.app.entities.User;
import gamestore.app.entities.enums.UserRole;
import gamestore.app.entities.models.bindingModels.GameDtoAdd;
import gamestore.app.entities.models.bindingModels.GameDtoEdit;
import gamestore.app.entities.models.bindingModels.UserLoggedIn;
import gamestore.app.entities.models.viewModels.GameDtoDetailedInfo;
import gamestore.app.entities.models.viewModels.GameDtoInfo;
import gamestore.app.entities.models.viewModels.GameDtoShopingCart;
import gamestore.app.repositories.GameRepository;
import gamestore.app.utils.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> findAll() {
        return this.gameRepository.findAll();
    }

    @Override
    public List<GameDtoInfo> findInfoForAll() {
        List<GameDtoInfo> info=new ArrayList<>();
        List<Game> all = this.gameRepository.findAll();
        for (Game game : all) {
            GameDtoInfo oneGameInfo = ModelParser.map(game, GameDtoInfo.class);
            info.add(oneGameInfo);
        }
        return info;
    }

    @Override
    public GameDtoEdit findById(Long id) {
        Game one = this.gameRepository.findOne(id);
        return ModelParser.map(one, GameDtoEdit.class);
    }

    @Override
    public Game create(Game game) {
        return this.gameRepository.save(game);
    }

    @Override
    public List<Game> multipleCreate(Iterable<Game> games) {
        return this.gameRepository.save(games);
    }

    @Override
    public String deleteById(Long id) {
        Game one = this.gameRepository.findOne(id);
        if (one==null){
            return null;
        }
        this.gameRepository.delete(id);
        return one.getTitle();
    }

    @Override
    public Boolean addGame(GameDtoAdd game) {
        Game gameToAdd = ModelParser.map(game, Game.class);
        this.gameRepository.saveAndFlush(gameToAdd);
        return true;
    }

    @Override
    public Boolean edit(GameDtoEdit game) {
        Game gameToEdit = ModelParser.map(game, Game.class);

        if (gameToEdit==null){
            return false;
        }
        this.gameRepository.saveAndFlush(gameToEdit);
        return true;
    }

    @Override
    public List<GameDtoDetailedInfo> findByTittle(String title) {

        List<GameDtoDetailedInfo> detailedInfos=new ArrayList<>();
        List<Game>games=this.gameRepository.findAllByTitle(title);
        for (Game game : games) {
            GameDtoDetailedInfo oneGameInfo = ModelParser.map(game, GameDtoDetailedInfo.class);
            if (oneGameInfo!=null){
                detailedInfos.add(oneGameInfo);
            }
        }
        return detailedInfos;
    }

    @Override
    public List<String> getAllOwnedGames(Long id) {
        return this.gameRepository.getAllOwnedGames(id);
    }

    @Override
    public List<Game> findByTittleForCart(String title) {
//        List<GameDtoShopingCart> gamesInCart=new ArrayList<>();
//        List<Game>games=this.gameRepository.findAllByTitle(title);
//        for (Game game : games) {
//            GameDtoShopingCart oneGameInfo = ModelParser.map(game, GameDtoShopingCart.class);
//            if (oneGameInfo!=null){
//                gamesInCart.add(oneGameInfo);
//            }
//        }
        return this.gameRepository.findAllByTitle(title);
    }


}
