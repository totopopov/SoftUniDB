package gamestore.app.core;



import gamestore.app.services.GameService;
import gamestore.app.services.UserService;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 17:05.
 */

public interface DataHandlerAble {

    public UserService getUserService();

    public GameService getGameService() ;

}
