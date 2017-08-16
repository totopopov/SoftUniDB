package gamestore.app.core.interpreters;


import gamestore.app.core.cmd.Executable;
import gamestore.app.core.DataHandlerAble;
import gamestore.app.utils.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Todor Popov using Lenovo on 22.4.2017 г. at 1:18.
 */

@Component
public class CommandInterpreter implements Interpreter {

    private final DataHandlerAble dataHandlerAble;
    private final Parameters parameters;

    @Autowired
    public CommandInterpreter(DataHandlerAble dataHandlerAble, Parameters parameters) {
        this.dataHandlerAble = dataHandlerAble;
        this.parameters = parameters;
    }

    @Override
    public Executable interpretCommand(String commandLine) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {

        String params[]=commandLine.split("\\|");
        String command=params[0];
        this.parameters.setParams(params);



        Executable executableReturn = null;
        Class<Executable> executableClass = (Class<Executable>) Class.forName("gamestore.app.core.cmd." + command + "Command");
            Constructor<Executable> declaredConstructor = executableClass.getDeclaredConstructor(DataHandlerAble.class,Parameters.class);
            declaredConstructor.setAccessible(true);
            Executable executable = declaredConstructor.newInstance(this.dataHandlerAble,this.parameters);
            executableReturn = executable;
        return executableReturn;
    }

}
