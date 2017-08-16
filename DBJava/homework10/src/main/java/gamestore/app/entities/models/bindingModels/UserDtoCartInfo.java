package gamestore.app.entities.models.bindingModels;

import gamestore.app.entities.Game;
import gamestore.app.entities.models.viewModels.GameDtoShopingCart;

import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 2.8.2017 г. at 15:08.
 */


public class UserDtoCartInfo {

    private Long id;
    private Set<GameDtoShopingCart> gamesInCart;


    public UserDtoCartInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<GameDtoShopingCart> getGamesInCart() {
        return gamesInCart;
    }

    public void setGamesInCart(Set<GameDtoShopingCart> gamesInCart) {
        this.gamesInCart = gamesInCart;
    }
}
