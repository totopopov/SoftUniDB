package gamestore.app.utils;

import gamestore.app.entities.models.bindingModels.UserLoggedIn;

/**
 * Created by Todor Popov using Lenovo on 2.8.2017 г. at 13:27.
 */


public class Session {
    private static UserLoggedIn loggedIn;

    public static UserLoggedIn getLoggedIn() {
        return loggedIn;
    }

    public static void setLoggedIn(UserLoggedIn loggedIn) {
        Session.loggedIn = loggedIn;
    }
}
