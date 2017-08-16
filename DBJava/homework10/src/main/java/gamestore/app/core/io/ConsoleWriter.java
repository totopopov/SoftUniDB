package gamestore.app.core.io;


import gamestore.app.core.io.interfaces.OutputWriter;
import org.springframework.stereotype.Component;

/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 16:10.
 */

@Component
public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void writeLine(String format, Object... params) {
        System.out.println(String.format(format,params));
    }
}
