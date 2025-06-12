package cn.cjxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/demo02")
public class Demo02Controller {

    //    post
    @RequestMapping(value = "/demo01", method = RequestMethod.POST)
    public void demo01(HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("hello------------------");
    }

    //    param 必须有id和deptId=3才行
    @RequestMapping(value = "/demo02", params = {"id", "deptId=3"}, method = RequestMethod.GET)
    public void demo02(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        String depId = request.getParameter("depId");
        response.getWriter().write("id: " + id + ",deptId: " + depId);
    }


    //    headers请求头
    @RequestMapping(value = "/demo03", method = RequestMethod.GET, headers = {"Host=localhost:8080"})
    public void demo03(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String host = request.getHeader("Host");
        response.getWriter().write("host" + host);
    }


}
