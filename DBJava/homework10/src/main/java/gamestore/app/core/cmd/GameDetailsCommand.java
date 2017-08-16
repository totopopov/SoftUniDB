package gamestore.app.core.cmd;


import gamestore.app.core.DataHandlerAble;
import gamestore.app.entities.models.viewModels.GameDtoDetailedInfo;
import gamestore.app.entities.models.viewModels.GameDtoInfo;
import gamestore.app.utils.Parameters;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 17:22.
 */

@Component
public class GameDetailsCommand extends BaseCommand {

    private final Parameters parameters;

    public GameDetailsCommand(DataHandlerAble dataHandlerAble, Parameters parameters) {
        super(dataHandlerAble);
        this.parameters = parameters;
    }


    @Override
    public String execute() throws ParseException {


        String title = this.parameters.getParams()[1];

        List<GameDtoDetailedInfo> byTittle = super.getDataHandlerAble().getGameService().findByTittle(title);

        if (byTittle.isEmpty()) {
            return String.format("No such title found (%s)", title);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d games with title '%s' found :", byTittle.size(), title));
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());

        try {
            for (GameDtoDetailedInfo gameDtoDetailedInfo : byTittle) {

                Field[] declaredFields = gameDtoDetailedInfo.getClass().getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    declaredField.setAccessible(true);
                    char[] charArray = declaredField.getName().toCharArray();
                    charArray[0]=Character.toUpperCase(charArray[0]);
                    String simpleName = new String(charArray);
                    Object o = declaredField.get(gameDtoDetailedInfo);
                    if (o!=null){
                        String value = o.toString();
                        sb.append(String.format("%s: %s",simpleName,value));
                        sb.append(System.lineSeparator());
                    } else {
                        sb.append(String.format("%s: %s",simpleName,null));
                        sb.append(System.lineSeparator());
                    }
                }

                sb.append(System.lineSeparator());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
