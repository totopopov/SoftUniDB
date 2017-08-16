package foto.utils.valids.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Todor Popov using Lenovo on 2.8.2017 г. at 1:17.
 */
public class PasswordValidator implements ConstraintValidator<Password,String> {
    private boolean containsDigit;
    private boolean containsLowerCase;
    private boolean containsUpperCase;
    private boolean containsSpecialSymbol;
    private int minLength;
    private int maxLength;

    @Override
    public void initialize(Password password) {
        this.containsDigit = password.containsDigit();
        this.containsLowerCase = password.containsLowerCase();
        this.containsUpperCase = password.containsUpperCase();
        this.containsSpecialSymbol = password.containsSpecialSymbols();
        this.minLength = password.minLength();
        this.maxLength = password.maxLength();
    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {

        if (string.length() < this.minLength || string.length() > this.maxLength) {
            return false;
        }
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher regex = pattern.matcher(string);
        if (!regex.find() && this.containsLowerCase) {
            return false;
        }
        Pattern patternTwo = Pattern.compile("[A-Z]");
        regex = patternTwo.matcher(string);
        if (!regex.find() && this.containsUpperCase) {
            return false;
        }
        Pattern patternThree = Pattern.compile("[0-9]");
        regex = patternThree.matcher(string);
        if (!regex.find() && this.containsDigit) {
            return false;
        }
        Pattern patternFour = Pattern.compile("[!@#$%^&*()_+<>?]");
        regex = patternFour.matcher(string);
        if (!regex.find() && this.containsSpecialSymbol) {
            return false;
        }
        return true;
    }
}
