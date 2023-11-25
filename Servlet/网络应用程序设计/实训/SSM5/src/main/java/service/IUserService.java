package service;


import domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserService {

    List<User> findAllUser();

    boolean userModify(User user);

    User findUserById(Integer uid);

    int deleteById(Integer uid);

    int addUser(User user);

    boolean updatePwd(Integer uid, String password, String newPassword);

    User findUserByNameAndPassword(String username, String password);

    User findUserByName(String username);

}
