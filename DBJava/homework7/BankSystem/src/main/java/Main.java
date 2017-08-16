import core.DataHandler;
import core.DataHandlerAble;
import core.Engine;
import core.interpreters.CommandInterpreter;
import core.interpreters.Interpreter;
import core.io.ConsoleReader;
import core.io.ConsoleWriter;
import interfaces.InputReader;
import interfaces.OutputWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 22:46.
 */
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        OutputWriter outputWriter=new ConsoleWriter();
        InputReader inputReader=new ConsoleReader();
        DataHandlerAble dataHandler=new DataHandler(em);
        Interpreter interpreter= new CommandInterpreter(dataHandler);
        Runnable engine = new Engine(inputReader,outputWriter,interpreter);
        engine.run();


        emf.close();
    }
}
