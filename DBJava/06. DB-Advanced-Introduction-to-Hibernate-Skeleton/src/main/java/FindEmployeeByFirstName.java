
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 19.7.2017 г. at 19:39.
 */
public class FindEmployeeByFirstName {

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("PersistenceUnit");

        EntityManager em =emf.createEntityManager();


        System.out.println("Enter name");

        String name=reader.readLine().trim();

        if (name==null || name.isEmpty()){
            System.out.println("Wrong Input");
            emf.close();
            return;
        }



        Query query = em.createQuery("FROM Employee e WHERE lower(e.firstName) like ?1");
        query.setParameter(1,name.toLowerCase()+"%");

        List<Employee> resultList = query.getResultList();

        for (Employee employee : resultList) {

            System.out.println(String.format("%s %s - %s - ($%.2f)",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getJobTitle(),
                    employee.getSalary()));
        }


        emf.close();
    }
}
