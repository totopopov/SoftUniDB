package core;


import models.UserAble;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 17:02.
 */
public class DataHandler implements DataHandlerAble {

    private EntityManager entityManager;
    private UserAble user;

    public DataHandler(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public void registerUser(UserAble user) {
        this.entityManager.getTransaction().begin();
        Query query = this.entityManager.createQuery("select u from User u where u.username=?1");
        query.setParameter(1,user.getUsername());
        List<UserAble> usersList= query.getResultList();
        if (usersList==null || usersList.isEmpty()){
            this.entityManager.persist(user);
        }
        this.entityManager.getTransaction().commit();
        this.entityManager.clear();

        if (usersList!=null && !usersList.isEmpty()){
            throw new IllegalArgumentException("Username already exist!");
        }
    }

    @Override
    public UserAble loginUser(UserAble user) {
        Query query = this.entityManager.createQuery("select u from User u where u.username=?1");
        query.setParameter(1,user.getUsername());
        this.user = (UserAble) query.getSingleResult();
        this.getEntityManager().clear();
        return this.user;
    }

    @Override
    public void logoutUser(UserAble user) {
        if (this.user==null){
            throw new IllegalStateException("No curreny user is logged");
        }
        this.user=null;
    }
}
