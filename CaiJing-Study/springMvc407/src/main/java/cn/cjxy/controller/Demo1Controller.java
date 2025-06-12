package cn.cjxy.controller;

import cn.cjxy.domain.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/demo01")
public class Demo1Controller {

    @RequestMapping("/demo01")
    public void demo01(Integer id, String cityName, Double GDP, Boolean capital, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        System.out.println(id + "," + cityName + "," + GDP + "," + capital);
        request.setCharacterEncoding("UTF-8");
//        设置响应编码格式
        response.setContentType("text/html;charset=utf-8");
//        往页面输出
        response.getWriter().write("id=" + id + "<hr/>");
        response.getWriter().write("cityName=" + cityName + "<hr/>");
        response.getWriter().write("GDP=" + GDP + "<hr/>");
        response.getWriter().write("capital=" + capital + "<hr/>");

    }

    @RequestMapping("/demo02")
    public void demo02(City city, HttpServletResponse response) throws IOException {
        //        设置响应编码格式
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(city.toString());
    }

    @RequestMapping("/demo03")
    public void demo03(Integer[] ids, HttpServletResponse response) throws IOException {
        System.out.println(Arrays.toString(ids));
        response.setContentType("text/html;charset=utf-8");
//        Arrays.toString(ids) 转换为数组包类再toString
        response.getWriter().write(Arrays.toString(ids));
    }

    @RequestMapping("/demo04")
    public void demo04(@RequestParam List<Integer> ids, HttpServletResponse response) throws IOException {
        System.out.println(ids);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(ids.toString());
    }

    @RequestMapping("/demo05")
    public void demo05(@RequestParam Set<Integer> ids, HttpServletResponse response) throws IOException {
        System.out.println(ids);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(ids.toString());
    }


    @RequestMapping("/demo06")
    public void demo06(@RequestParam Map<String, Objects> cityMap, HttpServletResponse response) throws IOException {
        System.out.println(cityMap);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(cityMap.toString());
    }


    @RequestMapping("/demo09")
    public String demo09(Map<String, Object> map, Model model, ModelMap modelMap) {
//        放值
        map.put("msg1", "hello map");
        model.addAttribute("msg2", "hello model");
        modelMap.addAttribute("msg3", "hello modelMap");
        return "forward:/map.jsp";
    }
}
