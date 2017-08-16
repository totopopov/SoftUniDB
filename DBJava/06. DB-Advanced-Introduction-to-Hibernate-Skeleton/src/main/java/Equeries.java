import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 19.7.2017 г. at 1:09.
 */
public class Equeries {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em =emf.createEntityManager();


        Query query = em.createQuery("SELECT e.firstName FROM Employee AS e WHERE e.salary>?");
            query.setParameter(0,new BigDecimal(50000));
        List<String> resultList = query.getResultList();

        for (String employee : resultList) {
            System.out.println(employee);
        }

        em.close();
        emf.close();

    }
}
