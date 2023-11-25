package controllers;


import beans.User;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//1.创建maven项目
//2.在pom.xml中添加依赖(Servlet-api，Tomcat-api，Spring-mvc等)
//3.配置前端控制器(web.mxl)
//4.springmvc主配置文件(处理器映射器HandlerMapping，
//                    处理器适配器HandlerAdapter，
//                    视图解析器ViewResolver，
//                    处理器Handler(Controller)-通常采用包扫描来替代(基于注解))
//5.实现Controller和View


@Controller
@RequestMapping("/controllers")
public class UserController {

        @RequestMapping("/login.do")
        public String login(HttpServletRequest request){
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println(age);
        if(id.equals("admin") && password.equals("123456")){
            return "index";
        }else {
            return "error";
        }
    }


//    @RequestMapping("/login.do")
//    public String login(String id,
//                        String password,
//                        @RequestParam(required = false,defaultValue = "0") int age,
//                        @RequestParam(required = false) String text) {
//        System.out.println(age);
//        if (id.equals("admin") && password.equals("123456")) {
//            return "index";
//        } else {
//            return "error";
//        }
//    }

    //@ResponseBody返回json字符串，不再交给视图解析器
//    @RequestMapping("/login.do")
//    @ResponseBody
//    public String login(@RequestBody User user) {
//        System.out.println(age);
//        System.out.println(password);
//        System.out.println(user.getId()+","+user.getPassword()+","+user.getAge());
//        if (user.getId().equals("admin") && user.getPassword().equals("123456")) {
//            return "index";
//        } else {
//            return "error";
//        }
//        System.out.println(json);
//        Gson gson = new Gson();
//        String json = gson.toJson(user);
//        return json;
//    }
}