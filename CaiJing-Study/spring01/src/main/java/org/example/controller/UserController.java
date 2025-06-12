package org.example.controller;

import org.example.service.UserService;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void save(){
        userService.save();
    }
}
