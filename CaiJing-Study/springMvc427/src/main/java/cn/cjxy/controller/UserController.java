package cn.cjxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")// /user/login
    public String login() { // 不进入拦截器
        System.out.println("login");
        return "login";
    }
    @GetMapping("/register")
    public String register() { // 不进入拦截器
        System.out.println("register");
        return "register";
    }
    @GetMapping("{id}") // /user/3 // 进入拦截器
    public String findById(@PathVariable Integer id) {
        System.out.println("findById");
        return "findById: " + id;
    }
    @GetMapping// /user
    public String findAll() { // 进入拦截器
        System.out.println("findAll");
        return "findAll";
    }
    @GetMapping("/hello") // /user/hello // 进入拦截器
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        System.out.println("handler...");
        mv.setViewName("/hello.jsp");
        return mv;
    }
}
