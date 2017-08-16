package gamestore.app.validator;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Todor Popov using Lenovo on 2.8.2017 г. at 1:03.
 */

@Component
@Constraint(validatedBy = PasswordMatchingValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PasswordMatching {

    String message() default "Password MisMatching";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
