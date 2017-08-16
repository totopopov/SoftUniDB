package gamestore.app.core.cmd;


import gamestore.app.core.DataHandlerAble;
import gamestore.app.entities.Game;
import gamestore.app.entities.User;
import gamestore.app.utils.Parameters;
import gamestore.app.utils.Session;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;


/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 17:22.
 */

@Component
public class RemoveFromShoppingCartCommand extends BaseCommand {

    private final Parameters parameters;

    public RemoveFromShoppingCartCommand(DataHandlerAble dataHandlerAble, Parameters parameters) {
        super(dataHandlerAble);
        this.parameters = parameters;
    }


    @Override
    public String execute() throws ParseException {

        if (Session.getLoggedIn()==null ){
            return "No logged in user.... so can't really add this to the cart. Kapish? :)";
        }

        String title = this.parameters.getParams()[1];

//        List<GameDtoShopingCart> byTittleForCart = super.getDataHandlerAble().getGameService().findByTittleForCart(title);
        List<Game> byTittleForCart = super.getDataHandlerAble().getGameService().findByTittleForCart(title);
        Long userId = Session.getLoggedIn().getId();
//        UserDtoCartInfo currentUser = super.getDataHandlerAble().getUserService().findById(userId);
        User currentUser = super.getDataHandlerAble().getUserService().findById(userId);
        if (currentUser==null){
            return "That is kind of immposible ! ";
        }

        if (byTittleForCart.isEmpty()){
            return String.format("No game found with title %s",title);
        }

        currentUser.getGamesInCart().removeAll(byTittleForCart);

        Boolean sucess = super.getDataHandlerAble().getUserService().addToUserCarts(currentUser);

        return sucess?String.format("%s removed from cart",title):"Something went wrong";
    }
}
