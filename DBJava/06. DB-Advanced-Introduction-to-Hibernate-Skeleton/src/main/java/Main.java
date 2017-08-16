import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.util.Date;

/**
 * Created by Todor Popov using Lenovo on 18.7.2017 г. at 16:09.
 */
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");

emf.close();

    }
}
