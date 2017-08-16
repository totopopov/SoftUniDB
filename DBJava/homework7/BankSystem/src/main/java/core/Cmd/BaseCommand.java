package core.Cmd;


import core.DataHandlerAble;

/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 17:00.
 */
public abstract class BaseCommand implements Executable {

    private DataHandlerAble dataHandle;

    protected BaseCommand(DataHandlerAble dataHandle) {
        this.dataHandle = dataHandle;
    }

    public DataHandlerAble getDataHandle() {
        return dataHandle;
    }
}
