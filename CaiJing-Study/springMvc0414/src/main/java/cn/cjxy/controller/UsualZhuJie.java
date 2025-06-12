package cn.cjxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/usual")
public class UsualZhuJie {
    /**
     *
     * @param id
     * @param name
     * @param password
     * @param age
     * @param response
     * @throws Exception
     */
    @RequestMapping("/requesterParam")
    public void requestParam(Integer id, @RequestParam("username") String name, String password, Integer age, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(id + " <br/>" + name + " <br/>" + password + " <br/>" + age);
    }
}
