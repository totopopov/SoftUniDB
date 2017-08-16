import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 19.7.2017 г. at 19:13.
 */
public class RemoveTowns {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");

        EntityManager em = emf.createEntityManager();


        Query query = em.createQuery("FROM Town t WHERE t.name=?1");


        Query queryPeople = em.createQuery("FROM Employee e WHERE e.address.town.name=?1");

        System.out.println("Enter Town Name to destroy");
        String townName=reader.readLine().trim();

        if (townName==null || townName.isEmpty()){
            System.out.println("Wrong Input");
            emf.close();
            return;
        }

        query.setParameter(1,townName);
        queryPeople.setParameter(1,townName);
        List<Employee> resultList = queryPeople.getResultList();

        List<Address> addressesToRemove=new ArrayList<>();

        for (Employee employee : resultList) {
            addressesToRemove.add(employee.getAddress());
            employee.setAddress(null);
            em.persist(employee);
        }
        int adresses=addressesToRemove.size();

        for (Address address : addressesToRemove) {
            em.remove(address);
        }
        Town town=null;
        if (addressesToRemove.size()==0){
            System.out.println("No such town found");
        }else {
            town = (Town) query.getSingleResult();
            em.remove(town);
        }

        em.getTransaction().begin();

        em.getTransaction().commit();
        if (town!=null){
            System.out.println(String.format("%d addresses in %s were deleted",adresses,town.getName()));
        }

        emf.close();
    }
}
