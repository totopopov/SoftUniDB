import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 19.7.2017 г. at 19:03.
 */
public class IncreaseSalary {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em=emf.createEntityManager();

        Query query = em.createQuery("FROM Employee e WHERE e.department.name IN (?1,?2,?3,?4)");
        query.setParameter(1,"Engineering");
        query.setParameter(2,"Tool Design");
        query.setParameter(3,"Marketing");
        query.setParameter(4,"Information Services");

        List<Employee> resultList = query.getResultList();

        em.getTransaction().begin();
        for (Employee employee : resultList) {

            employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));
            em.persist(employee);
            System.out.println(String.format("%s %s ($%.2f)"
            ,employee.getFirstName(),employee.getLastName(), employee.getSalary()));
        }
        em.getTransaction().commit();

        emf.close();
    }
}
