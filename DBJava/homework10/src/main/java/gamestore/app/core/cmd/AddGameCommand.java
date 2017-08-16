package gamestore.app.core.cmd;



import gamestore.app.core.DataHandlerAble;
import gamestore.app.entities.enums.UserRole;
import gamestore.app.entities.models.bindingModels.GameDtoAdd;
import gamestore.app.entities.models.bindingModels.UserLoggedIn;
import gamestore.app.utils.DataValidator;
import gamestore.app.utils.Parameters;
import gamestore.app.utils.Session;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 17:22.
 */

@Component
public class AddGameCommand extends BaseCommand {

    private final Parameters parameters;

    public AddGameCommand(DataHandlerAble dataHandlerAble, Parameters parameters) {
        super(dataHandlerAble);
        this.parameters = parameters;
    }


    @Override
    public String execute() throws ParseException {

        if (Session.getLoggedIn()==null || Session.getLoggedIn().getUserRole().equals(UserRole.USER)){
            return "Not authorized operation !";
        }

        String params[]=this.parameters.getParams();


        DateFormat df = new SimpleDateFormat("dd-mm-yyyy");

        GameDtoAdd game = new GameDtoAdd(params[1], new  BigDecimal(params[2]),
                new  BigDecimal(params[3]),params[4],params[5],params[6],df.parse(params[7]));


        String validate = DataValidator.validate(game);
        if (validate!=null){
            return validate;
        }

        this.getDataHandlerAble().getGameService().addGame(game);


        return String.format("Added %s",game.getTitle());
    }
}
