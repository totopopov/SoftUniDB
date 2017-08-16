import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 19.7.2017 г. at 1:09.
 */
public class Equeries2 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em =emf.createEntityManager();


        Query query = em.createQuery("SELECT e FROM Employee AS e JOIN e.department AS d WHERE d.name=?");
            query.setParameter(0,"Research and Development");
        List<Employee> resultList = query.getResultList();

        resultList.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getFirstName).reversed())
                .forEach(e-> System.out.println(String.format("%s %s from %s - $%.2f",e.getFirstName(),
                        e.getLastName(), e.getDepartment().getName(),e.getSalary())));

        em.close();
        emf.close();

    }
}
