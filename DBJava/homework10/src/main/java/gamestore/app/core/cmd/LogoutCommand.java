package gamestore.app.core.cmd;



import gamestore.app.core.DataHandlerAble;
import gamestore.app.entities.models.bindingModels.UserLoggedIn;
import gamestore.app.utils.Parameters;
import gamestore.app.utils.Session;
import org.springframework.stereotype.Component;


/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 17:22.
 */

@Component
public class LogoutCommand extends BaseCommand {

    private final Parameters parameters;

    public LogoutCommand(DataHandlerAble dataHandlerAble, Parameters parameters) {
        super(dataHandlerAble);
        this.parameters = parameters;
    }


    @Override
    public String execute()  {

        if (Session.getLoggedIn()==null){
            return "No user logged in";
        }


        String name=Session.getLoggedIn().getFullName();

        Session.setLoggedIn(null);


        return String.format("User %s successfully logged out",name);
    }
}
