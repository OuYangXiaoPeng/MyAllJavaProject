package cn.cjxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/demo")//要访问该类的方法，会再加上一层路径
public class DemoController {

    @RequestMapping("/demo01")
    //@ResponseBody //可以让他不识别成路径,以json格式返回
    public String demo01() {
        return "hello";
    }

    //  1.返回页面
    @RequestMapping("/demo02")
    public String demo02() {
        return "index01";
    }


    //    2.返回ModeAndView，想追加数据的时候
    @RequestMapping("/demo03")
    public ModelAndView demo03() {
        //构建mv对象
        ModelAndView mv = new ModelAndView();
        //存放的数据
        mv.addObject("msg", "床前明月光，疑是地上霜。");
        //跳转视图
        mv.setViewName("index02");
        //返回视图
        return mv;
    }

    //    3.转发    地址栏不发生变化
    @RequestMapping("/demo04")
    public String demo04() {
        return "forward:/index03.jsp";
    }

    //    3.重定向   地址栏发生变化
    @RequestMapping("/demo05")
    public String demo05() {
        return "redirect:/index04.jsp";
    }


    //    4.返回void    一般用于ajax请求
    @RequestMapping("/demo06")
    public void demo06(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("床前明月光，疑是地上霜。");
    }
}
