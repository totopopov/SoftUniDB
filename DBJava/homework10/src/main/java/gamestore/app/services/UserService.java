package gamestore.app.services;

import gamestore.app.entities.User;
import gamestore.app.entities.models.bindingModels.UserDtoCartInfo;
import gamestore.app.entities.models.bindingModels.UserLoggedIn;
import gamestore.app.entities.models.bindingModels.UserRegisterDto;

import java.util.List;

public interface UserService {

    List<User> findAll();

    Boolean create(UserRegisterDto user);

    List<User> multipleCreate(Iterable<User> users);

    void deleteById(Long id);

    UserLoggedIn findUserByEmailAndPassword(String email, String password);

    //    UserDtoCartInfo findById(Long id);
    User findById(Long id);

    //    Boolean addToUserCarts(UserDtoCartInfo user);
    Boolean addToUserCarts(User user);
}
