package gamestore.app.core.cmd;


import gamestore.app.core.DataHandlerAble;
import gamestore.app.entities.Game;
import gamestore.app.entities.User;
import gamestore.app.utils.Parameters;
import gamestore.app.utils.Session;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 17:22.
 */

@Component
public class BuyGamesCommand extends BaseCommand {

    private final Parameters parameters;

    public BuyGamesCommand(DataHandlerAble dataHandlerAble, Parameters parameters) {
        super(dataHandlerAble);
        this.parameters = parameters;
    }


    @Override
    public String execute() throws ParseException {

        if (Session.getLoggedIn()==null ){
            return "No logged in user.... so can't really add this to the cart. Kapish? :)";
        }


        Long userId = Session.getLoggedIn().getId();
//        UserDtoCartInfo currentUser = super.getDataHandlerAble().getUserService().findById(userId);
        User currentUser = super.getDataHandlerAble().getUserService().findById(userId);
        if (currentUser==null){
            return "That is kind of immposible ! ";
        }


        Set<Game> gamesInCart = currentUser.getGamesInCart();
        currentUser.setBoughtGames(gamesInCart);
        currentUser.setGamesInCart(new HashSet<>());
        Boolean sucess = super.getDataHandlerAble().getUserService().addToUserCarts(currentUser);

        StringBuilder sb = new StringBuilder();

        sb.append("Successfully bought games:").append(System.lineSeparator());

        for (Game game : gamesInCart) {
            sb.append(game.getTitle()).append(System.lineSeparator());
        }

        return sucess?sb.toString():"Something went wrong";
    }
}
