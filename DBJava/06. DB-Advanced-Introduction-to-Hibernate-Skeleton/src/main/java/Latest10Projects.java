import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 19.7.2017 г. at 18:44.
 */
public class Latest10Projects {
    public static void main(String[] args) {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em=emf.createEntityManager();


        List<Project> ids = em.
                createQuery("SELECT p.id FROM Project p ORDER BY p.startDate DESC").setMaxResults(10).getResultList();

        Query query = em.createQuery("FROM Project p WHERE p.id IN (?1) ORDER BY p.name");
        query.setParameter(1,ids);

        List<Project> resultList = query.getResultList();

        for (Project pr : resultList) {

            int length = pr.getDescription().length();

            System.out.println(String.format("%s %s %s %s"
                    ,pr.getName()
                    ,pr.getDescription().substring(0,Math.min(length,50))
                    ,pr.getStartDate()
                    ,pr.getEndDate()));
        }

        emf.close();
    }
}
