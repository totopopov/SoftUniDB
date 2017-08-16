package gamestore.app.core;


import gamestore.app.services.GameService;
import gamestore.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 17:02.
 */

@Component
public class DataHandler implements DataHandlerAble {

    private final UserService userService;
    private final GameService gameService;


    @Autowired
    public DataHandler(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    public UserService getUserService() {
        return userService;
    }

    public GameService getGameService() {
        return gameService;
    }
}
