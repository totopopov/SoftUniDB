package gamestore.app.core.cmd;



import gamestore.app.core.DataHandlerAble;
import gamestore.app.entities.models.bindingModels.UserLoggedIn;
import gamestore.app.entities.models.bindingModels.UserRegisterDto;
import gamestore.app.utils.DataValidator;
import gamestore.app.utils.Parameters;
import gamestore.app.utils.Session;
import org.springframework.stereotype.Component;


/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 17:22.
 */

@Component
public class LoginCommand extends BaseCommand {

    private final Parameters parameters;

    public LoginCommand(DataHandlerAble dataHandlerAble, Parameters parameters) {
        super(dataHandlerAble);
        this.parameters = parameters;
    }


    @Override
    public String execute()  {

        if (Session.getLoggedIn()!=null){
            return "User already logged in";
        }

        String email= this.parameters.getParams()[1];
        String password= this.parameters.getParams()[2];

        UserLoggedIn user = this.getDataHandlerAble().getUserService().findUserByEmailAndPassword(email, password);

        if (user==null){
            return "Wrong Username or Password";
        }


        Session.setLoggedIn(user);


        return String.format("Successfully logged in %s",user.getFullName());
    }
}
