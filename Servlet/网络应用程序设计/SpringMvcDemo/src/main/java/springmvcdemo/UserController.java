package springmvcdemo;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if ("myName".equals(userName) && "myPassword".equals(password)) {
            modelAndView.setViewName("index");
            modelAndView.addObject("userName", userName);
        } else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
}
