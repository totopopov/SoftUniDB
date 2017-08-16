import entities.WizzardDeposit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Todor Popov using Lenovo on 21.7.2017 г. at 20:06.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        Calendar cal=Calendar.getInstance();
        Calendar calInYear=Calendar.getInstance();
        calInYear.setTime(new Date());
        calInYear.add(Calendar.YEAR,3);

        cal.setTime(new Date());
        WizzardDeposit w1 = new WizzardDeposit("Ruby",
                "Red",
                "Fire Mage",
                146,
                "Ogre Dred",
                15,"Minions",
                cal.getTime(),
                BigDecimal.valueOf(200),
                BigDecimal.valueOf(5),BigDecimal.valueOf(2), calInYear.getTime(),false);


        WizzardDeposit w2 = new WizzardDeposit("Khali",
                "Veil",
                "Earth Mage",
                217,
                "Ogre Dred",
                18,"Minions",
                cal.getTime(),
                BigDecimal.valueOf(200),
                BigDecimal.valueOf(5),BigDecimal.valueOf(2),calInYear.getTime(),false);


        WizzardDeposit w3 = new WizzardDeposit("Tom",
                "Soyer",
                "Mind Mage",
                217,
                "DreadLord Soyer",
                18,"Demons club",
                cal.getTime(),
                BigDecimal.valueOf(200),
                BigDecimal.valueOf(5),BigDecimal.valueOf(2), calInYear.getTime() ,false);

        em.getTransaction().begin();
        em.persist(w1);
        em.persist(w2);
        em.persist(w3);

        em.getTransaction().commit();
        emf.close();
    }
}
