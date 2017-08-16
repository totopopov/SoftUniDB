import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Created by Todor Popov using Lenovo on 19.7.2017 г. at 0:48.
 */
public class DataRefresh {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM Employee AS e WHERE e.id=?");
            query.setParameter(0,1);
        Employee empl = (Employee) query.getSingleResult();
        empl.setFirstName(empl.getFirstName().toUpperCase());

        em.refresh(empl);


        em.persist(empl);

        System.out.println(empl.getFirstName());

    }
}
