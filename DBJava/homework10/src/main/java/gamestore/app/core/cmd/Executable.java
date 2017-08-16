package gamestore.app.core.cmd;

import java.text.ParseException;

/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 17:00.
 */
public interface Executable {
    String execute() throws ParseException;
}
