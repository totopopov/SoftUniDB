package softuni.users.services.api;

import softuni.users.entities.User;

import java.util.Date;
import java.util.List;

public interface UserService {

    void persist(User user);
    List<Object[]> findUsersByEmailProvider(String provider);

    Integer prepareInactiveUsersForRemoval(Date date);

    void deleteInactiveUsers();

    List<User> findAll();

    Integer countByProfilePictureGreaterThan(byte[] length);

}
