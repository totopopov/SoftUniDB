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
@Constraint(validatedBy = PasswordValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface Password {
    String message() default "Invalid Password";
    int minLength() default 6;
    int maxLength() default 30;
    boolean containsDigit() default false;
    boolean containsLowerCase() default false;
    boolean containsUpperCase() default false;
    boolean containsSpecialSymbols() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
