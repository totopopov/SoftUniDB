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
public class AllGamesCommand extends BaseCommand {

    private final Parameters parameters;

    public AllGamesCommand(DataHandlerAble dataHandlerAble, Parameters parameters) {
        super(dataHandlerAble);
        this.parameters = parameters;
    }


    @Override
    public String execute() throws ParseException {

        List<GameDtoInfo> infoForAll = super.getDataHandlerAble().getGameService().findInfoForAll();

        if (infoForAll.isEmpty()) {
            return "No games to show, the admins have not put them in the DB...";
        }

        return infoForAll.stream().map(s -> String.format("%s %s", s.getTitle(), s.getPrice()))
                .collect(Collectors.joining(System.lineSeparator()));

    }
}
