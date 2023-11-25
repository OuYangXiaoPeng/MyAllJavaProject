package controllers;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.IUserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.util.WebUtils;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/backLogin.do")
    public ModelAndView login(Model session, String username, String password, HttpServletResponse response) {
        User userI = new User();
        userI.setUname(username);
        userI.setPassword(password);
        ModelAndView modelAndView = new ModelAndView("manage/login");
        User user = userService.findUserByNameAndPassword(username, password);
        if (user != null) {
            Cookie cookie = new Cookie("userLogin", username + ":" + password);
            cookie.setMaxAge(7 * 24 * 60 * 60); // 设置cookie有效期为7天
            response.addCookie(cookie);
            return new ModelAndView("redirect:manaUser");
        } else {
            session.addAttribute("user", userI);
            modelAndView.addObject("errorMessage", "用户名或者密码错误!");
        }
        return modelAndView;
    }

    @RequestMapping("/Login.do")
    public String loginPage(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, "userLogin");
        if (cookie != null) {
            String[] userDetails = cookie.getValue().split(":");
            User user = userService.findUserByNameAndPassword(userDetails[0], userDetails[1]);
            if (user != null) {
                return "redirect:manaUser";
            }
        }
        return "manage/login";
    }

    @RequestMapping("/LoginOut.do")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = WebUtils.getCookie(request, "userLogin");
        if (cookie != null) {
            cookie.setMaxAge(0); // 设置cookie立即过期
            response.addCookie(cookie);
        }
        return "redirect:Login.do";
    }

    @RequestMapping("/Register.do")
    public String registerPage() {
        return "manage/register";
    }

    @RequestMapping("/addUser.do")
    public String addUser() {
        return "manage/user-add";
    }

    @PostMapping("/checkUserName")
    @ResponseBody
    public String checkUserName(@RequestParam("userName") String userName) {
        // 检查用户名是否存在的逻辑
        if (userService.findUserByName(userName) != null) {
            return "exist";
        }
        return "notExist";
    }


    @RequestMapping("/manaUser")
    public String manageUser(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        List<User> users = userService.findUsersByPage(page, pageSize);

        model.addAttribute("users", users);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);

        return "manage/user";
    }

    @RequestMapping("/Register")
    public ModelAndView register(String userName, String passWord, String passWord2, User user, Model session) {

        ModelAndView modelAndView = new ModelAndView("manage/register");
        user.setUname(userName);
        user.setPassword(passWord);
        user.setPassword2(passWord2);

        if (userService.findUserByName(userName) != null) {
            modelAndView.addObject("errorMessage", "用户名已存在!");
            session.addAttribute("user", user);
            return modelAndView;
        }
        // 检查用户名长度是否符合要求
        if (userName.length() < 3 || userName.length() > 12) {
            modelAndView.addObject("errorMessage", "用户名长度必须在3-12位之间");
            session.addAttribute("user", user);
            return modelAndView;
        }
        // 检查用户名是否只包含数字、字母和下划线
        if (!userName.matches("[\\w]+")) {
            modelAndView.addObject("errorMessage", "用户名只能包含数字、字母和下划线");
            session.addAttribute("user", user);
            return modelAndView;
        }
        //检查密码是否相同
        if (!passWord.equals(passWord2)) {
            modelAndView.addObject("errorMessage", "密码不相同!");
            session.addAttribute("user", user);
            return modelAndView;
        }
        // 检查密码长度是否符合要求
        if (passWord.length() < 3 || passWord.length() > 12) {
            modelAndView.addObject("errorMessage", "密码长度必须在3-12位之间");
            session.addAttribute("user", user);
            return modelAndView;
        }
        //检查密码是否只包含数字、字母和下划线
        if (!passWord.matches("[\\w]+")) {
            modelAndView.addObject("errorMessage", "密码只能包含数字、字母和下划线");
            session.addAttribute("user", user);
            return modelAndView;
        }

        userService.addUser(user);
        return new ModelAndView("redirect:/Login.do");
    }

    @RequestMapping("/addUser")
    public ModelAndView addUser(Model session, String userName, String passWord,
                                String passWord2, User user) {

        ModelAndView modelAndView = new ModelAndView("manage/user-add");
        user.setUname(userName);
        user.setPassword(passWord);
        user.setPassword2(passWord2);

        if (userService.findUserByName(userName) != null) {
            modelAndView.addObject("errorMessage", "用户名已存在!");
            session.addAttribute("user", user);
            return modelAndView;
        }
        // 检查用户名长度是否符合要求
        if (userName.length() < 3 || userName.length() > 12) {
            modelAndView.addObject("errorMessage", "用户名长度必须在3-12位之间");
            session.addAttribute("user", user);
            return modelAndView;
        }
        // 检查用户名是否只包含数字、字母和下划线
        if (!userName.matches("[\\w]+")) {
            modelAndView.addObject("errorMessage", "用户名只能包含数字、字母和下划线");
            session.addAttribute("user", user);
            return modelAndView;
        }
        //检查密码是否相同
        if (!passWord.equals(passWord2)) {
            modelAndView.addObject("errorMessage", "密码不相同!");
            session.addAttribute("user", user);
            return modelAndView;
        }
        // 检查密码长度是否符合要求
        if (passWord.length() < 3 || passWord.length() > 12) {
            modelAndView.addObject("errorMessage", "密码长度必须在3-12位之间");
            session.addAttribute("user", user);
            return modelAndView;
        }
        //检查密码是否只包含数字、字母和下划线
        if (!passWord.matches("[\\w]+")) {
            modelAndView.addObject("errorMessage", "密码只能包含数字、字母和下划线");
            session.addAttribute("user", user);
            return modelAndView;
        }

        userService.addUser(user);
        return new ModelAndView("redirect:/manaUser");
    }

    @RequestMapping("/modifyUserPage")
    public String modifyUserPage(Model model, Integer uid) {
        User user = userService.findUserById(uid);
        model.addAttribute("user", user);
        return "manage/user-modify";
    }

    @RequestMapping("/modifyUser")
    public ModelAndView manaUser(User user, String passWord) {
        user.setPassword(passWord);
        userService.userModify(user);
        return new ModelAndView("redirect:/manaUser.do");
    }

    @RequestMapping("/delUser")
    public ModelAndView deleteUser(Integer uid) {
        userService.deleteById(uid);
        return new ModelAndView("redirect:/manaUser.do");
    }

}