package core;

import core.Cmd.Executable;
import core.interpreters.Interpreter;
import interfaces.InputReader;
import interfaces.OutputWriter;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 16:57.
 */
public class Engine implements Runnable {
    private InputReader reader;
    private OutputWriter writer;
    private Interpreter interpreter;

    public Engine(InputReader reader, OutputWriter writer, Interpreter interpreter) {
        this.reader = reader;
        this.writer = writer;
        this.interpreter=interpreter;
    }

    @Override
    public void run() {
        String input;

        this.writer.writeLine("UI not impemented yet, contact vendor for full version @ totopopov@gmail.com");
        while (true){
            try {
                input=reader.readLine();
                Executable executable = this.interpreter.interpretCommand(input);
                String executeResponce = executable.execute();
                this.writer.writeLine(executeResponce);
                if ("Quit".equals(input) || "q".equals(input)){
                    break;
                }

            }catch (ClassNotFoundException e){

            } catch (NoSuchMethodException e) {
                this.writer.writeLine("Invalid Command;");
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
