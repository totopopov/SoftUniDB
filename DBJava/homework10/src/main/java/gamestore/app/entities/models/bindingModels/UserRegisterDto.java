package gamestore.app.entities.models.bindingModels;

import gamestore.app.validator.PasswordMatching;

import javax.validation.constraints.Pattern;

/**
 * Created by Todor Popov using Lenovo on 2.8.2017 г. at 0:26.
 */

@PasswordMatching
public class UserRegisterDto {
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    public UserRegisterDto() {
    }


    @Pattern(regexp = "(?=.*@)(?=.*\\.).+",message = "Invalid email.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).+",message = "Invalid passowrd!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
