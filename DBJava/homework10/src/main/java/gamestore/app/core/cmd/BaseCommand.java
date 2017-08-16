package gamestore.app.core.cmd;


import gamestore.app.core.DataHandlerAble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 17:00.
 */

@Component
public abstract class BaseCommand implements Executable {

    private DataHandlerAble dataHandlerAble;

    @Autowired
    public BaseCommand(DataHandlerAble dataHandlerAble) {
        this.dataHandlerAble = dataHandlerAble;
    }

    public DataHandlerAble getDataHandlerAble() {
        return this.dataHandlerAble;
    }

    public void setDataHandlerAble(DataHandlerAble dataHandlerAble) {
        this.dataHandlerAble = dataHandlerAble;
    }
}
