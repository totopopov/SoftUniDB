import entityManager.DBContext;
import entityManager.EntityManager;
import models.User;

import java.time.LocalDate;

/**
 * Created by Todor Popov using Lenovo on 10.7.2017 г. at 17:10.
 */
public class OrmDemo {
    public static void main(String[] args) throws Exception {
        try (DBContext em=new EntityManager()) {
            User user = new User("Ivan", 25, LocalDate.now());
            em.persist(user);

        }



    }
}
