package gamestore.app.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Todor Popov using Lenovo on 2.8.2017 г. at 1:17.
 */
public class PasswordValidator implements ConstraintValidator<Password,String> {


    @Override
    public void initialize(Password password) {

    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        return  true;
    }
}
