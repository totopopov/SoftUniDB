package gamestore.app.terminal;


import gamestore.app.core.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Todor Popov using Lenovo on 1.8.2017 г. at 23:48.
 */

@Component
public class Terminal implements CommandLineRunner {

    private final Engine engine;

    @Autowired
    public Terminal(Engine engine) {
        this.engine = engine;
    }


    @Override
    public void run(String... strings) throws Exception {
        this.engine.run();
    }
}
