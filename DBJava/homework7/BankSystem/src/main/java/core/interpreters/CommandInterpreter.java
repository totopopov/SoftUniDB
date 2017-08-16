package core.interpreters;




import core.Cmd.Executable;
import core.Cmd.RegisterCommand;
import core.DataHandlerAble;
import core.annotation.InjectParams;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Todor Popov using Lenovo on 22.4.2017 г. at 1:18.
 */
public class CommandInterpreter implements Interpreter {

    private DataHandlerAble dataHandlerAble;

    public CommandInterpreter(DataHandlerAble dataHandlerAble) {
        this.dataHandlerAble = dataHandlerAble;
    }

    @Override
    public Executable interpretCommand(String line) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
        String[] params = line.split("\\s+");

        String commandName = params[0];
        Executable executableReturn = null;

            Class<Executable> executableClass = (Class<Executable>) Class.forName("core.Cmd." + commandName + "Command");
            Constructor<Executable> declaredConstructor = executableClass.getDeclaredConstructor(DataHandlerAble.class);
            declaredConstructor.setAccessible(true);
            Executable executable = declaredConstructor.newInstance(this.dataHandlerAble);
            Field[] fields = executable.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(InjectParams.class)) {
                    field.setAccessible(true);
                    String[] injection=params;
                    field.set(executable, injection);
                    break;
                }
            }
            executableReturn = executable;


        return executableReturn;
    }

}
