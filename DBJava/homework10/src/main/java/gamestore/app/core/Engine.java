package gamestore.app.core;


import gamestore.app.core.cmd.Executable;
import gamestore.app.core.interpreters.Interpreter;
import gamestore.app.core.io.interfaces.InputReader;
import gamestore.app.core.io.interfaces.OutputWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 16:57.
 */

@Component
public class Engine implements Runnable {
    private final InputReader reader;
    private final OutputWriter writer;
    private final Interpreter interpreter;

    @Autowired
    public Engine(InputReader reader, OutputWriter writer, Interpreter interpreter) {
        this.reader = reader;
        this.writer = writer;
        this.interpreter = interpreter;
    }

    public InputReader getReader() {
        return reader;
    }

    public OutputWriter getWriter() {
        return writer;
    }

    public Interpreter getInterpreter() {
        return interpreter;
    }


    @Override
    public void run() {
        String input;

        while (true){
            try {
                this.writer.writeLine("Awaiting input:");
                input=reader.readLine();
                Executable executable = this.interpreter.interpretCommand(input);
                String executeResponce = executable.execute();
                this.writer.writeLine(executeResponce);
                if ("Quit".equals(input) || "q".equals(input)){
                    break;
                }

            }catch (ClassNotFoundException e){

            } catch (NoSuchMethodException|ArrayIndexOutOfBoundsException e) {
                this.writer.writeLine("Invalid Command;");
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | ParseException e) {
                this.writer.writeLine(e.getStackTrace().toString());
            }
        }
    }
}
