package gamestore.app.core.interpreters;


import gamestore.app.core.cmd.Executable;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Todor Popov using Lenovo on 22.4.2017 г. at 1:18.
 */
public interface Interpreter {
    Executable interpretCommand(String command) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException;
}
