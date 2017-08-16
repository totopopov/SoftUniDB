package car_dealer.app.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 2.8.2017 г. at 2:40.
 */
public class DataValidator {
    public static <T> String  validate(T target){
        ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> validate = factory.getValidator().validate(target);
        if (!validate.isEmpty()){
            for (ConstraintViolation<T> constraint : validate) {
                return constraint.getMessage();
            }
        }
        return null;
    }

}
