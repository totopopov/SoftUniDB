package gamestore.app.core.cmd;



import gamestore.app.core.DataHandlerAble;
import gamestore.app.entities.models.bindingModels.UserRegisterDto;
import gamestore.app.utils.DataValidator;
import gamestore.app.utils.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;


/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 17:22.
 */

@Component
public class RegisterCommand extends BaseCommand {

    private final Parameters parameters;

    public RegisterCommand(DataHandlerAble dataHandlerAble, Parameters parameters) {
        super(dataHandlerAble);
        this.parameters = parameters;
    }


    @Override
    public String execute()  {

        String email = this.parameters.getParams()[1];
        String password = this.parameters.getParams()[2];
        String confirmPassword = this.parameters.getParams()[3];
        String fullName = this.parameters.getParams()[4];

        UserRegisterDto registerUser= new UserRegisterDto();
        registerUser.setEmail(email);
        registerUser.setPassword(password);
        registerUser.setConfirmPassword(confirmPassword);
        registerUser.setFullName(fullName);

        String validate = DataValidator.validate(registerUser);
        if (validate!=null){
            return validate;
        }


        Boolean isRegistered = super.getDataHandlerAble().getUserService().create(registerUser);

        if (!isRegistered){
            return String.format("Email: %s already registered",email);
        }


        return String.format("%s was registered",fullName);
    }
}
