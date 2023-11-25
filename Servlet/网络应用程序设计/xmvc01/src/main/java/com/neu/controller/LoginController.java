package com.neu.controller;

import com.neu.pojo.User;
import com.neu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录功能Controller
 *
 * @author Admin
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String getIndex() {
        return "login";
    }

    /**
     * 登录验证
     *
     * @param user    用户信息
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public String getLogin(User user, HttpServletRequest request) {

        // 调用用户服务的登录验证方法
        boolean loginResult = userService.isLogin(user);
        // 如果登录成功
        if (loginResult) {
            // 获取 HttpSession 对象
            HttpSession session = request.getSession();
            // 将用户名保存到 session 中
            session.setAttribute("user", user.getUserName());
            // 跳转到用户主页
            return "redirect:/users/index";
        } else { // 登录失败
            // 跳转回登录页面
            return "redirect:/index";
        }
    }

}
