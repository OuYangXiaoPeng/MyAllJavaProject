package springmvcdemo;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterController implements Controller {
    private UserList ulist;

    public UserList getUlist() {
        return ulist;
    }

    public void setUlist(UserList ulist) {
        this.ulist = ulist;
    }

    public RegisterController() {

    }

    public RegisterController(UserList ulist) {
        this.ulist = ulist;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView view = new ModelAndView();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        for (User user : ulist.getUlist()) {
            if (user.getUsername().equals(userName)) {
                view.setViewName("falier");
                return view;
            }
        }
        ulist.getUlist().add(new User(userName, password));
        view.setViewName("success");
        return view;
    }
}
