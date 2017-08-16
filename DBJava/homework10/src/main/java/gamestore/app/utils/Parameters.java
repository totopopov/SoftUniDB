package gamestore.app.utils;

import org.springframework.stereotype.Component;

/**
 * Created by Todor Popov using Lenovo on 1.8.2017 г. at 23:50.
 */

@Component
public class Parameters {
    
    private String[] params;

    public Parameters() {
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }
}
