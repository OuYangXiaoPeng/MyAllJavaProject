package cn.cjxy.userManageMent.controller;

import cn.cjxy.userManageMent.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//拦截器
public class MyInterceptor implements HandlerInterceptor {

    //返回值为true就是通过 为false就是拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       //检查是否登录  -----从session种获取用户信息。有就说明登陆了
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            //没有该用户信息  不通过  返回登录页让他去登录
            response.sendRedirect("/login.jsp");
            return false;
        }

        return true;
    }
}
