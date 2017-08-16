import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 19.7.2017 г. at 13:44.
 */
public class ConcurentChanges {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");

        EntityManager em1 = emf.createEntityManager();

        EntityManager em2 = emf.createEntityManager();

        //First time only the secon commit goes through
        //Now when object is locked, the second EM can not get a hold of the object.
        Town towns = (Town) em1.createQuery("SELECT t FROM Town AS t").getResultList().get(0);

        em1.getTransaction().begin();
        towns.setName("Marakua");
        em1.persist(towns);
        em1.lock(towns, LockModeType.PESSIMISTIC_WRITE);

        em2.getTransaction().begin();
        towns.setName("Boiler");
        em2.persist(towns);
        em2.lock(towns, LockModeType.PESSIMISTIC_WRITE);

        System.out.println(em1.getLockMode(towns));
        System.out.println(em2.getLockMode(towns));


        em2.getTransaction().commit();
        em1.getTransaction().commit();

        em1.close();
        em2.close();
        emf.close();
    }
}
