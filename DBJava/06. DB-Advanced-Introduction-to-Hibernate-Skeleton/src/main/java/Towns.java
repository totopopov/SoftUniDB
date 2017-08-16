import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 18.7.2017 г. at 17:10.
 */
public class Towns {
    public static void main(String[] args) {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("PersistenceUnit");

        EntityManager em= emf.createEntityManager();

        List<Town> towns = em.createQuery("SELECT t FROM Town AS t").getResultList();

        for (Town town : towns) {
            if (town.getName().length()>5){
                em.detach(town);
            }
        }

        for (Town town : towns) {
            if (em.contains(town)){
                town.setName(town.getName().toLowerCase());
                em.persist(town);
            }
        }



        em.getTransaction().begin();
        em.getTransaction().commit();

        em.close();
        emf.close();

        String debug="";
    }
}
