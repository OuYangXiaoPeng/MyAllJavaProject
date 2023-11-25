package com.neu.controller;

import com.neu.pojo.User;
import com.neu.service.UserService;
import com.neu.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 用户管理Controller
 *
 * @author Admin
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public ModelAndView index(Model model,String userName) {

        // 创建 ModelAndView 对象并设置返回视图名和数据模型
        ModelAndView mav = new ModelAndView("users");
        if (userName == null || userName.isEmpty()) {
            // 调用用户服务的查询方法
            List<User> userList = userService.getUsers();
            mav.addObject("userList", userList);
        } else {
            // 调用用户服务的查询方法
            List<User> users = userService.getUsersByKeyword(userName);
            model.addAttribute("keyword",userName);
            mav.addObject("userList", users);
        }
        // 返回 ModelAndView 对象
        return mav;
    }

    @RequestMapping("/preAdd")
    public String getAddUserPage() {
        return "/addUser";
    }

    @RequestMapping("/add")
    public ModelAndView addUser(Model model, String userName, String password) {
        User user = new User();
        user.setId(IDUtil.getID());
        user.setUserName(userName);
        user.setPassword(password);

        // 检测用户是否存在
        if (userService.getUser(userName) != null) {
            ModelAndView modelAndView = new ModelAndView("addUser");
            modelAndView.addObject("errorMessage", "用户名已存在!");
            model.addAttribute("USER", user);
            return modelAndView;
        }

        this.userService.addUser(user);
        return new ModelAndView("redirect:/users/index");
    }

    @RequestMapping("/editPage")
    public String editPage(Model model, String id) {
        User user = userService.getSingleUser(id);
        model.addAttribute("user", user);
        return "/updateUser";
    }

    @RequestMapping("/update")
    public String updateUser(String id, String userName, String password) {
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setPassword(password);
        this.userService.updateUser(user);
        return "redirect:/users/index";
    }

    @RequestMapping("/delete")
    public String deleteUser(User user) {
        int count = this.userService.delUser(user.getId());
        return "redirect:/users/index";
    }

}
