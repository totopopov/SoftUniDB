package core.io;

import interfaces.OutputWriter;

/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 16:10.
 */
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
