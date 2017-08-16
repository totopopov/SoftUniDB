package gamestore.app.core.cmd;



import gamestore.app.core.DataHandlerAble;
import gamestore.app.entities.enums.UserRole;
import gamestore.app.entities.models.bindingModels.GameDtoAdd;
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
public class DeleteGameCommand extends BaseCommand {

    private final Parameters parameters;

    public DeleteGameCommand(DataHandlerAble dataHandlerAble, Parameters parameters) {
        super(dataHandlerAble);
        this.parameters = parameters;
    }


    @Override
    public String execute() throws ParseException {

        if (Session.getLoggedIn()==null || Session.getLoggedIn().getUserRole().equals(UserRole.USER)){
            return "Not authorized operation !";
        }

        String params[]=this.parameters.getParams();

        Long id = Long.parseLong(params[1]);

        String tittle = super.getDataHandlerAble().getGameService().deleteById(id);

        if (tittle==null){
            return String.format("Game not foind with ID:%d",id);
        }

        return String.format("Deleted %s",tittle);
    }
}
