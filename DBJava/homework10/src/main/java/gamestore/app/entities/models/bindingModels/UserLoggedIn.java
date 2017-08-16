package gamestore.app.entities.models.bindingModels;

import gamestore.app.entities.enums.UserRole;

/**
 * Created by Todor Popov using Lenovo on 2.8.2017 г. at 15:08.
 */


public class UserLoggedIn {


    private Long id;

    private UserRole userRole;

    private String fullName;

    public UserLoggedIn() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
