package com.dd.interceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @Project: FourRun
 * @Author: Silly-episode(DYZ89)
 * @Date: 2022/3/22 22:25
 * @FileName: LoginInterceptor
 * @Description: 登录拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler)
            throws Exception {
        if(request.getSession().getAttribute("name") == null) {
            response.sendRedirect("/login_register");
            return false;
        }
        return true;
    }
}
