import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Todor Popov using Lenovo on 19.7.2017 г. at 1:45.
 */
public class Dsq {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em=emf.createEntityManager();

        //part 1
        List<Address> addresses = em.createQuery("SELECT a FROM Address AS a ORDER BY a.employees.size DESC,a.town.name ASC")
                .setMaxResults(10).getResultList();


        System.out.println("All addresses:");

        for (Address address : addresses) {
            System.out.println(String.format("%s  located in %s - %d employees",
                    address.getText(),address.getTown().getName(),address.getEmployees().size()));
        }

        //part 2

        System.out.println("Insert employee ID:");


        try {
            int employeeID = Integer.parseInt(reader.readLine());

            Query query = em.createQuery("FROM Employee AS e WHERE e.id=?");

            query.setParameter(0,employeeID);

            Employee empl  = (Employee) query.getSingleResult();

            System.out.println(String.format("%s %s %s - projects: %s",
                    empl.getFirstName(), empl.getLastName(),empl.getJobTitle(),
                    empl.getProjects().stream().map(Project::getName).collect(Collectors.joining(", "))));

        }catch (NumberFormatException e){
            System.out.println("Wrong input");
        }

        //part 3

        List<Employee> employees = em
                .createQuery("SELECT e FROM Employee AS e JOIN e.projects AS p WHERE YEAR(p.startDate) BETWEEN 2001 AND 2003")
                .getResultList();

        //just to exercise it
//        List<Integer> resultList =
//                em.createQuery("SELECT p.id FROM Project as p WHERE YEAR(p.startDate) BETWEEN 2001 AND 2003").getResultList();
//
//        Query query = em.createQuery("FROM Employee AS e JOIN e.projects as p WHERE p.id IN (:ids)");
//        query.setParameter("ids",resultList);
//
//        List<Employee> resultList1 = query.getResultList();

        for (Employee employee : employees) {
            System.out.println(String.format("%s %s  manager: %s %s",
                    employee.getFirstName(),employee.getLastName(),
                    employee.getManager().getFirstName(),
                    employee.getManager().getLastName()));
            for (Project project : employee.getProjects()) {
                System.out.println(String.format("-----%s  %s  %s ",
                        project.getName(),project.getStartDate(),project.getDescription()));
            }
        }

        //part4
        List<Department> departments = em
                .createQuery("FROM Department AS d WHERE d.employees.size>5 ORDER BY d.employees.size").getResultList();

        System.out.println(departments.size());

        for (Department department : departments) {
            System.out.println(String.format("--%s - Manager : %s %s , Employees: %d",
                    department.getName(),department.getManager().getFirstName(),
                    department.getManager().getLastName(),department.getEmployees().size()));
        }

        em.close();
        emf.close();



    }
}
