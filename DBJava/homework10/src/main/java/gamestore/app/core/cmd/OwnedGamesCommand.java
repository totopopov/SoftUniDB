package gamestore.app.core.cmd;


import gamestore.app.core.DataHandlerAble;
import gamestore.app.entities.enums.UserRole;
import gamestore.app.entities.models.viewModels.GameDtoInfo;
import gamestore.app.utils.Parameters;
import gamestore.app.utils.Session;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 17:22.
 */

@Component
public class OwnedGamesCommand extends BaseCommand {

    private final Parameters parameters;

    public OwnedGamesCommand(DataHandlerAble dataHandlerAble, Parameters parameters) {
        super(dataHandlerAble);
        this.parameters = parameters;
    }


    @Override
    public String execute() throws ParseException {

        if (Session.getLoggedIn()==null ){
            return "No logged in user.... so you own nothing as guest :)";
        }

        List<String> allOwnedGames = super.getDataHandlerAble().getGameService().getAllOwnedGames(Session.getLoggedIn().getId());

        String games = String.join(System.lineSeparator(), allOwnedGames);

        StringBuilder sb = new StringBuilder(System.lineSeparator()).append("Owned Games:").append(System.lineSeparator());
        sb.append(games);
        return sb.toString();
    }
}
