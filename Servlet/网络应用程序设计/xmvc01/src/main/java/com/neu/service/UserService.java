package com.neu.service;

import com.neu.pojo.User;

import java.util.List;

/**
 * 用户管理逻辑类
 *
 * @author Admin
 */
public interface UserService {

    User getUser(String var1);

    User getSingleUser(String var1);

    List<User> getUsersByKeyword(String keyword);

    boolean isLogin(User var1);

    List<User> getUsers();

    int addUser(User var1);

    int updateUser(User var1);

    int delUser(String var1);

}
