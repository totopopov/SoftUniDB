package products_shop.app.services;

import products_shop.app.dto.bind.UserDtoRegister;
import products_shop.app.dto.view.UserDto;
import products_shop.app.dto.view.UserDtoViewSold;
import products_shop.app.dto.view.UserDtoViewWrapper;
import products_shop.app.entities.User;

import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 2:31.
 */


public interface UserService {
     void registerUser(UserDtoRegister user);
     List<UserDto> findAll();

     List<UserDtoViewSold> findUsersWithSoldProducts();

     UserDtoViewWrapper findAllUserByAtLeastOneSell();
}
