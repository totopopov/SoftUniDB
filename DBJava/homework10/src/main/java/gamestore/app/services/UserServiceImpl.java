package gamestore.app.services;

import gamestore.app.entities.User;
import gamestore.app.entities.enums.UserRole;
import gamestore.app.entities.models.bindingModels.UserDtoCartInfo;
import gamestore.app.entities.models.bindingModels.UserLoggedIn;
import gamestore.app.entities.models.bindingModels.UserRegisterDto;
import gamestore.app.repositories.UserRepository;
import gamestore.app.utils.ModelParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }


    @Override
    public Boolean create(UserRegisterDto userDto) {
        User user=this.userRepository.findUserByEmail(userDto.getEmail());
        if (user!=null){
            return false;
        }
        user= ModelParser.getInstance().map(userDto,User.class);
        boolean firstUser = this.userRepository.findAll().isEmpty();
        user.setUserRole(firstUser? UserRole.ADMIN:UserRole.USER);
         this.userRepository.save(user);
         return true;
    }

    @Override
    public List<User> multipleCreate(Iterable<User> users) {
        return this.userRepository.save(users);
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.delete(id);
    }

    @Override
    public UserLoggedIn findUserByEmailAndPassword(String email, String password) {
        User userByEmailAndPassword = this.userRepository.findUserByEmailAndPassword(email, password);
        return ModelParser.map(userByEmailAndPassword,UserLoggedIn.class);

    }

    @Override
    public User findById(Long id) {

//        User one = this.userRepository.findOne(id);
//        return ModelParser.map(one,UserDtoCartInfo.class);
        return this.userRepository.findOne(id);
    }

    @Override
    public Boolean addToUserCarts(User user) {
//        User updated = ModelParser.map(user, User.class);
//        if (updated==null){
//            return false;
//        }
//
//        this.userRepository.saveAndFlush(updated);
        this.userRepository.saveAndFlush(user);
        return true;
    }

}
