package cn.cjxy.userManageMent.controller;

import cn.cjxy.userManageMent.domain.User;
import cn.cjxy.userManageMent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session;

    /**
     *
     * @param user  存用户输入的用户名和密码
     * @param checkCode  接收验证码
     * @param model 存提示信息
     * @return
     */
    @RequestMapping("/login")
    public String login(User user, String checkCode, Model model) {
        //获取验证码
        String sessionCode = (String) session.getAttribute("sessionCode");
        //对比验证码
        if (!checkCode.equals(sessionCode)) {
            model.addAttribute("error","验证码错误，请重新输入！");
            //重新登录
            return "forward:/login.jsp";
        }
        //根据用户名查询用户  如果没有此用户，或者密码错误，提示他并且跳回登录
        User dbUser=userService.login(user.getUsername());
        if(dbUser==null || !user.getPassword().equals(dbUser.getPassword())) {
            model.addAttribute("error","用户名或密码错误！");
            return "forward:/login.jsp";
        }
        //除此之外的情况就是已经查到且密码比对一致
        //将用户信息存入session
        session.setAttribute("loginUser",dbUser);
        //跳转到首页
        return "redirect:/user/list";
    }

    /**
     * 查询所有
     * 构建一个userList集合出来传递到前端
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        //携带数据跳转到用户信息页面
        return "/list.jsp";
    }

    /**
     * 用户数据回显--通过id查询
     * 查出来之后携带user信息到修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/findById")
    public String findById(Integer id, Model model) {
        User updateUser=userService.findById(id);
        model.addAttribute("user",updateUser);
        return "/update.jsp";
    }

    /**
     * 真正执行修改
     * 修改完之后回到list页面重新查询  /user/list
     * @param user
     * @return
     */
    @RequestMapping("/update")
    public String update(User user) {
        userService.update(user);
        //修改完之后回到list页面重新查询  /user/list
        return "redirect:/user/list";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public String delete(Integer id) {
        userService.delete(id);

        //删除完之后回到list页面重新查询  /user/list
        return "redirect:/user/list";
    }

    /**
     *
     * @param user
     * @return
     */
    @RequestMapping("/save")
    public String save(User user) {
        userService.save(user);
        //修改完之后回到list页面重新查询  /user/list
        return "redirect:/user/list";
    }
}
