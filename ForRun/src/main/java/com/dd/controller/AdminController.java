package com.dd.controller;
import com.dd.entity.User;
import com.dd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    //将“/”映射为login_register页面
    @RequestMapping("/" )
    public String login () {return "login_register";}

    //登录
    @PostMapping("/result")
    public String result (
            HttpServletRequest request,
            @RequestParam("name") String name,
            @RequestParam("pwd") String pwd) {
        HttpSession session = request.getSession();
        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
            //判断登录
        Boolean flag=userService.login(user);
        if(flag) {
            //登录成功，并将user.name加入session
            session.setAttribute("name",name);
            return "Home";
        }
        else {
            //登录失败，返回登录注册页面
            return "login_register";
        }
    }

    //注册
    @PostMapping("/addUser")
    public String addUser(
            @RequestParam("newName") String name,
            @RequestParam("pwd1") String pwd
    ) {
        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
        //判断注册结果
        boolean flag =userService.register(user);
        if(flag) {
            //注册成功
            return "login_register";
        }
        //注册失败
        return "login_register";
    }
}
