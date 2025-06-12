package cn.cjxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping("/UserTest")
    @ResponseBody
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "你好");
        mv.setViewName("/hello.jsp");
        return mv;
    }
}
