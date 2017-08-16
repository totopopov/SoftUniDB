package core.Cmd;

import core.DataHandlerAble;
import core.annotation.InjectParams;
import models.User;
import models.UserAble;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 17:22.
 */
public class RegisterCommand extends BaseCommand {

    @InjectParams
    private String[] params;

    public RegisterCommand(DataHandlerAble dataHandle) {
        super(dataHandle);
    }


    @Override
    public String execute()  {

        String username=params[1];
        String password=params[2];
        String email=params[3];
        UserAble user=null;
        Class<UserAble> userClass=null;
        try {

            userClass = (Class<UserAble>) Class.forName(User.class.getName());
            Constructor<UserAble> declaredConstructor = userClass.getDeclaredConstructor(String.class, String.class,String.class);
            declaredConstructor.setAccessible(true);
            user = declaredConstructor.newInstance(username, password,email);


        } catch ( NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            super.getDataHandle().registerUser(user);
            return String.format("%s was registered in the system",username);

        }catch (IllegalArgumentException e){
            return e.getMessage();
        }

    }
}
