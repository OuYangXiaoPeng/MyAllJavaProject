package cn.cjxy.controller;

import cn.cjxy.domain.User;
import cn.cjxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 标注为 Controller 层并注入 IoC 容器
public class UserController {

    @Autowired // 根据类型注入 UserService
    private UserService userService;

    // 根据 id 查询用户
    public User findById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID 必须大于 0");
        } else {
            return userService.findById(id);
        }
    }

    // 添加用户
    public void addUser(User user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            System.out.println("用户信息不完整");
        } else {
            userService.addUser(user);
        }
    }

    //删除
    public void deleteUser(int id) {
        if (id <= 0) {
            System.out.println("ID 必须大于 0");
        } else {
            userService.deleteUser(id);
        }
    }

    //更改用户
    public void updateUserById(int id,String username,String password) {
        if (userService.findById(id) == null) {
            System.out.println("id不存在");
        } else {
            userService.updateUserById(id,username,password);
        }
    }
}