package gamestore.app.core.cmd;


import gamestore.app.core.DataHandlerAble;
import gamestore.app.entities.enums.UserRole;
import gamestore.app.entities.models.bindingModels.GameDtoAdd;
import gamestore.app.entities.models.bindingModels.GameDtoEdit;
import gamestore.app.utils.DataValidator;
import gamestore.app.utils.Parameters;
import gamestore.app.utils.Session;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 17:22.
 */

@Component
public class EditGameCommand extends BaseCommand {

    private final Parameters parameters;

    //this I borrowed :)
    private final Map<Class, Class> mapper = new LinkedHashMap<Class, Class>() {{
        put(int.class, Integer.class);
        put(double.class, Double.class);
        put(float.class, Float.class);
        put(long.class, Long.class);
        put(boolean.class, Boolean.class);
    }};

    public EditGameCommand(DataHandlerAble dataHandlerAble, Parameters parameters) {
        super(dataHandlerAble);
        this.parameters = parameters;
    }


    @Override
    public String execute() throws ParseException {

        if (Session.getLoggedIn() == null || Session.getLoggedIn().getUserRole().equals(UserRole.USER)) {
            return "Not authorized operation !";
        }

        String params[] = this.parameters.getParams();

        Long id = Long.parseLong(params[1]);

        GameDtoEdit game = this.getDataHandlerAble().getGameService().findById(id);

        if (game == null) {
            return "No such game found";
        }

        for (int i = 2; i < params.length; i++) {
            String[] paramArgs = params[i].split("=");
            String fieldName = paramArgs[0];
            if (fieldName.equals("id")||fieldName.equals("Id")){
                return "Cannot change Id, nice try btw :)";
            }
            String value = paramArgs[1];

            try {
                Field field = game.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                Class<?> fieldType = field.getType();

                //No primitives in this class, though if we wanted to e generic would have been great.
                fieldType = fieldType.isPrimitive() ?
                        this.mapper.get(fieldType) :
                        fieldType;

                Constructor<?> fieldConstructor = fieldType.getConstructor(String.class);
                field.set(game, fieldConstructor.newInstance(value));
            } catch (NoSuchFieldException e) {
                return String.format("Filed Not Found: %s . %n Carefull not to mess it up this time.",e.getMessage());
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                return e.getStackTrace().toString();
            }
        }

        String validate = DataValidator.validate(game);
        if (validate != null) {
            return validate;
        }

        Boolean edit = super.getDataHandlerAble().getGameService().edit(game);

        if (!edit){
            return "Something went wrong";
        }

        return String.format("Editted game with ID: %d, current title:%s",game.getId(),game.getTitle() );
    }
}
