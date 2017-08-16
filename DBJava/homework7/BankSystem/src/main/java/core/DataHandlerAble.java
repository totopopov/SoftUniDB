package core;


import models.UserAble;

import javax.persistence.EntityManager;

/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 17:05.
 */
public interface DataHandlerAble {

    EntityManager getEntityManager();

    void registerUser(UserAble user);

    UserAble loginUser(UserAble user);

    void logoutUser(UserAble user);

}
