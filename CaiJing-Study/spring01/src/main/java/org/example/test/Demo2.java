package org.example.test;

import org.example.controller.UserController;
import org.example.dao.UserDao;
import org.example.service.UserService;

public class Demo2 {
    public static void main(String[] args) {
        /*
        要保存一个用户必须手动创建一个个对象，并且将对象组装起来，最后组装成UserController对象，然后才能调用
         */
        UserDao userDao = new UserDao();
        UserService userService = new UserService(userDao);
        UserController userController = new UserController(userService);

        userController.save();

    }
}
