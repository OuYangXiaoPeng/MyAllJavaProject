package cn.cjxy.controller;

import cn.cjxy.domain.User;
import cn.cjxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 显示用户列表页面
    @GetMapping("/listPage")
    public String showUserList(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "userList";
    }

    // 添加用户处理
    @PostMapping("/add")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/user/listPage";
    }

    // 显示修改用户页面
    @GetMapping("/edit/{id}")
    public String showEditPage(@PathVariable Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    // 修改用户处理
    @PostMapping("/update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/user/listPage";
    }

    // 删除用户
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/user/listPage";
    }
}