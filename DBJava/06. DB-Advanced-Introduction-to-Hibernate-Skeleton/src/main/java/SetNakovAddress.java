import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 19.7.2017 г. at 1:09.
 */
public class SetNakovAddress {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em =emf.createEntityManager();

        Address address=new Address("Vitoshka 15",null);

        em.persist(address);

        Query query = em.createQuery("FROM Employee as e WHERE e.lastName=?");
        query.setParameter(0,"Nakov");
        Employee nakov = (Employee) query.getSingleResult();

        nakov.setAddress(address);

        em.getTransaction().begin();
        em.getTransaction().commit();

        em.clear();


        Employee nakovRefreshed = (Employee) query.getSingleResult();

        em.close();
        emf.close();

        System.out.println(nakov.getAddress().getText());


    }
}
