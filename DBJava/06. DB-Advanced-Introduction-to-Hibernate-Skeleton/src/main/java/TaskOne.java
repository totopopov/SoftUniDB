import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * Created by Todor Popov using Lenovo on 18.7.2017 г. at 16:09.
 */
public class TaskOne {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");

        EntityManager em = emf.createEntityManager();


        //Task One
        Employee president = (Employee) em.createQuery("SELECT e FROM Employee AS e WHERE e.jobTitle LIKE '%President%'")
                .getResultList().get(0);

        if (president == null) {
            System.out.println("No suitable candidate found.");
        }

        Department rNd = new Department("Operation And Maintanace", president);

        Town town = new Town("Blagoevgrad");

        Address address0 = new Address("N. Petrini 24", town);
        Address address1 = new Address("Elenovo 177", town);
        Address address2 = new Address("Orlova Chuka 32", town);
        Address address3 = new Address("Ivan Vazow 64", town);
        Address address4 = new Address("Mata Harry 2", town);

        Employee stamat = new Employee("Stamat", "Stamatov", "Stamatov", "Project manager", rNd, president,
                new Timestamp(LocalDate.now().toEpochDay()), 5000L, address0);

        Employee miro = new Employee("Miro", "Mirev", "Mirev", "Physics specialist", rNd, president,
                new Timestamp(LocalDate.now().toEpochDay()), 5500L, address1);
        Employee nestor = new Employee("Nestor", "Vinov", "Lozanov", "Chemist", rNd, president,
                new Timestamp(LocalDate.now().toEpochDay()), 4000L, address2);
        Employee monika = new Employee("Monika", "Haighs", "Peneva", "Mathematics and Biology",
                rNd, president, new Timestamp(LocalDate.now().toEpochDay()), 5200L, address3);
        Employee sara = new Employee("Sara", "Kerrigan", "Blades", "Field Operations and Mind Control",
                rNd, president, new Timestamp(LocalDate.now().toEpochDay()), 5300L, address4);


        //begin transaction can be at the end, the EM context would be taken nevertheless begin transaction was not initiated.
        em.getTransaction().begin();

        em.persist(nestor);
        em.persist(address0);
        em.persist(address1);
        em.persist(address2);
        em.persist(address3);
        em.persist(address4);
        em.persist(miro);
        em.persist(rNd);
        em.persist(town);
        em.persist(monika);
        em.persist(sara);
        em.persist(stamat);

        em.getTransaction().commit();


        em.close();
        emf.close();





    }
}
