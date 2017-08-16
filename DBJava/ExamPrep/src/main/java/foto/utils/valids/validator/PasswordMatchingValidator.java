package foto.utils.valids.validator;


import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Todor Popov using Lenovo on 2.8.2017 г. at 1:05.
 */

@Component
public class PasswordMatchingValidator implements ConstraintValidator<PasswordMatching,Object> {

    @Override
    public void initialize(PasswordMatching passwordMatching) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
//        if (o instanceof UserRegisterDto){
//            UserRegisterDto registerUser=(UserRegisterDto)o;
//            return registerUser.getPassword().equals(registerUser.getConfirmPassword());
//        }
        return false;
    }
}
