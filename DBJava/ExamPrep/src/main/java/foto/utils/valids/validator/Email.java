package foto.utils.valids.validator;

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
@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
    String message() default "Invalid email format!";
    boolean checkEmail() default false;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

