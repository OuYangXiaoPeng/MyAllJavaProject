package controllers;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.IUserService;
import util.Constant;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//1.创建maven项目
//2.在pom.xml中添加依赖(Servlet-api，Tomcat-api，Spring-mvc等)
//3.配置前端控制器(web.mxl)
//4.springmvc主配置文件(处理器映射器HandlerMapping，
//                    处理器适配器HandlerAdapter，
//                    视图解析器ViewResolver，
//                    处理器Handler(Controller)-通常采用包扫描来替代(基于注解))
//5.实现Controller和View


@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/test2")
    @ResponseBody
    public List findUser() {
        List<User> users = userService.findAllUser();
        return users;
    }

    @RequestMapping("/checkUser")
    @ResponseBody
    public Map<String, Object> checkUser(String username, String password) {
        Map<String, Object> result = new HashMap<>();
        boolean success = false;
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            User user = userService.findUserByNameAndPassword(username, password);
            if (user != null) {
                success = true;
            }
        }
        result.put("exists", success);
        return result;
    }

    @RequestMapping("/checkUserName")
    @ResponseBody
    public Map<String, Object> checkUserName(String username) {
        Map<String, Object> result = new HashMap<>();
        boolean exists = userService.findUserByName(username) != null;
        result.put("exists", exists);
        return result;
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public Map<String, Object> insertUser(String username, String password,String gender) {
        Map<String, Object> result = new HashMap<>();
        boolean success = false;
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password) && !StringUtils.isEmpty(gender)) {
            User user = new User();
            user.setUname(username);
            user.setPassword(password);
            user.setGender(gender);
            userService.addUser(user);
            success = true;
        }
        result.put("exists", success);
        return result;
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public Map<String, Object> deleteUser(String username) {
        Map<String, Object> result = new HashMap<>();
        if (!StringUtils.isEmpty(username)) {
            User user = userService.findUserByName(username);
            if (user != null) {
                userService.deleteById(user.getUid());
                result.put("exists", true);
                return result;
            }
        }
        result.put("exists", false);
        return result;
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public Map<String, Object> updatePassword(String username, String oldPassword, String newPassword) {
        Map<String, Object> result = new HashMap<>();
        boolean success = false;
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(oldPassword) && !StringUtils.isEmpty(newPassword)) {
            User user = userService.findUserByName(username);
            if (user != null && user.getPassword().equals(oldPassword)) {
                user.setPassword(newPassword);
                userService.userModify(user);
                success = true;
            }
        }
        result.put("exists", success);
        return result;
    }




    @RequestMapping("/backLoginPage")
    public String loginPage() {
        return "manage/login";
    }

    @RequestMapping("/index.do")
    public String indexPage() {
        return "manage/index";
    }


    @RequestMapping("backLogin.do")
    public String login(HttpSession session, String username, String password) {
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            if (username.equals(password) && username.equals("admin")) {
                session.setAttribute("admin", "admin");
                return "manage/index";
            }
        }
        return "manage/login";
    }


    @RequestMapping("/manaUser")
    public String manageUser(Integer pageNum, Model model) {
        if (pageNum != null) {
            PageHelper.startPage(pageNum, Constant.MU_PAGE_SIZE);
        } else {
            PageHelper.startPage(1, Constant.MU_PAGE_SIZE);
        }
        List<User> users = userService.findAllUser();
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("users", users);
        return "manage/user";
    }

    @RequestMapping("/addUser")
    public ModelAndView addUser(String userName, String passWord, String gender, String email, String phone, String address) {
        // 根据用户名查询数据库里是否已经存在该用户
        if (userService.findUserByName(userName) != null) {
            // 如果存在，返回错误信息
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("msg", "该用户名已存在！");
            modelAndView.setViewName("manage/user-add");
            return modelAndView;
        }
        User user = new User();
        user.setUname(userName);
        user.setPassword(passWord);
        user.setGender(gender);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        userService.addUser(user);
        return new ModelAndView("redirect:/manaUser.do");
    }


    @RequestMapping("addUserPage")
    public String addUserPage() {
        return "manage/user-add";
    }

    @RequestMapping("/modifyUserPage")
    public String modifyUserPage(Model model, Integer uid) {
        User user = userService.findUserById(uid);
        model.addAttribute("user", user);
        return "manage/user-modify";
    }

    @RequestMapping("/modifyUser")
    public ModelAndView manaUser(Integer uid, String userName, String passWord, String gender, String email, String phone, String address) {
        User user = new User();
        user.setUid(uid);
        user.setUname(userName);
        user.setPassword(passWord);
        user.setGender(gender);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        userService.userModify(user);
        return new ModelAndView("redirect:/manaUser.do");
    }

    @RequestMapping("/delUser")
    public ModelAndView deleteUser(Integer uid) {
        userService.deleteById(uid);
        return new ModelAndView("redirect:/manaUser.do");
    }

    @RequestMapping("/updateUserPage")
    public String updateUserPage(Model model, HttpSession session) {
        User sessionUser = (User) session.getAttribute("user");
        User user = userService.findUserById(sessionUser.getUid());
        model.addAttribute("user", user);
        return "front/update";
    }

    @RequestMapping("/updateUser")
    public ModelAndView updateUser(Integer uid, String uname, String gender, String email, String phone, String address) {
        User user = new User();
        user.setUid(uid);
        user.setUname(uname);
        user.setGender(gender);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        userService.userModify(user);
        return new ModelAndView("redirect:/index.do");
    }

}