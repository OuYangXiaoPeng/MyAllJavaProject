package cn.cjxy.controller;

import cn.cjxy.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    //    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public void login(HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("新增---------------------");
    }

    /**
     * @param response
     * @param id
     * @throws Exception
     * @PathVariable 用于接路径参数，将方法的形参和路径参数进行绑定
     * @RequestParam 接收前端请求参数，当接收的参数变量名与表单的name属性不一致时，可以使用@PathVariable来绑定
     */
    @PutMapping("/{id}")
    public void update(HttpServletResponse response, @PathVariable Integer id) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("新增---------------------" + id);
    }

    @GetMapping
    public void list(HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("查询所有");
    }

    @GetMapping("/{id}")//http://localhost:8080/user/id
    public void findById(HttpServletResponse response, @PathVariable Integer id) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("根据id查询-----------------" + id);
    }

    @DeleteMapping("/{id}")
    public void delete(HttpServletResponse response, @PathVariable Integer id) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("根据id删除-------------" + id);
    }

    //    返回json对象
    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser() throws IOException {
        return new User(1, "张三", "12346", 23,"@123.com",new Date());
    }

    //    返回json对象
    @RequestMapping("/getUsers")
    @ResponseBody
    public List<User> getUsers() throws IOException {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "张三", "12346", 23));
        users.add(new User(2, "张", "12346", 25));
        users.add(new User(3, "三", "12346", 21));
        users.add(new User(3, "三", "12346", 21, "@123.com",new Date()));
        return users;
    }
}
