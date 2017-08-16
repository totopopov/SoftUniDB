package foto.utils.valids.validator;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Todor Popov using Lenovo on 2.8.2017 г. at 1:03.
 */

@Component
public class EmailValidator implements ConstraintValidator<Email, String> {
    private boolean checkEmail;

    @Override
    public void initialize(Email email) {
        this.checkEmail = email.checkEmail();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (!email.matches("^[a-zA-Z0-9]+[\\w.\\-_]+[a-zA-Z0-9]+@[a-zA-Z]+[a-zA-Z.]+[a-zA-Z]+$") && this.checkEmail) {
            throw new IllegalArgumentException("Invalid email!");
        }
        return true;
    }
}
