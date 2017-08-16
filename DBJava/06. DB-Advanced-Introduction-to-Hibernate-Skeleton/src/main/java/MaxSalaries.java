import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;


public class MaxSalaries {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.
                        createEntityManagerFactory("PersistenceUnit");

        EntityManager em = emf.createEntityManager();


        Query query = em.createQuery("SELECT d.name, MAX(e.salary)" +
                " FROM Department d JOIN d.employees e GROUP BY d.name " +
                "HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000 ");

        List resultList =  query.getResultList();

        for (Object o : resultList) {
            Object[] entry = (Object[]) o;
            String name= (String) entry[0];
            BigDecimal salary= (BigDecimal) entry[1];

            System.out.println(String.format("%s --- %.2f",name,salary));
        }


    }
}
