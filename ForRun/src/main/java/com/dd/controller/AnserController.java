package com.dd.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



@Controller
public class AnserController {

    @Autowired
    IndexController IC;

    //映射answer
    @RequestMapping("/Answer")
    public String answer() {
        return "Answer";
    }

    //映射exit
    @RequestMapping(value = "/exit",method = RequestMethod.GET)
    public String exit () {
        return "Home";
    }

    //映射redo，返回到 IndexController中的RequestMapping中的具体value值
    @RequestMapping(value = "/redo",method = RequestMethod.GET)
    public String redo(
            HttpServletRequest request
    ){
        HttpSession session = request.getSession();
        //通过session中所存的model值判断再来一次是银映射到哪
        if(1==(int)session.getAttribute("model")) {
            return "redirect:/selectModel1";
        }
        else if(2==(int)session.getAttribute("model")){

            return "redirect:/selectModel2";
        }
        else {
            return "redirect:/selectModel3";
        }
    }
}
