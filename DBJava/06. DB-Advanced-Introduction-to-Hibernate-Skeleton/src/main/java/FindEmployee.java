import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Todor Popov using Lenovo on 18.7.2017 г. at 17:30.
 */
public class FindEmployee {
    public static void main(String[] args) throws IOException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");

        EntityManager em = emf.createEntityManager();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] name = reader.readLine().trim().split("\\s+");

        if (name.length == 1 && name[0].isEmpty()) {
            name = null;
        }

        Query query = null;
        if (name != null) {
            switch (name.length) {
                case 2:
                    query = em.createQuery("SELECT e FROM Employee AS e WHERE e.firstName=? AND e.lastName=?");
                    query.setParameter(0, name[0]);
                    query.setParameter(1, name[1]);

                    break;
                case 1:
                    query = em.createQuery("SELECT e FROM Employee AS e WHERE e.firstName=?");
                    query.setParameter(0, name[0]);
                    break;
                case 3:
                    query = em.createQuery("SELECT e FROM Employee AS e WHERE e.firstName=? AND e.lastName=? AND e.middleName=?");
                    query.setParameter(0, name[0]);
                    query.setParameter(2, name[2]);
                    query.setParameter(1, name[1]);
                    break;
                default:
                    System.out.println("Wrong Input");
                    break;
            }

        }
        if (query != null) {
            Employee employee = (Employee) query.getSingleResult();
            if (employee != null) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        em.close();
        emf.close();
    }
}
