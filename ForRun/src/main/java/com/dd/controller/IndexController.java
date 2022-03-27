package com.dd.controller;
import com.dd.entity.Bank;
import com.dd.entity.Grade;
import com.dd.service.BankService;
import com.dd.service.GradeService;
import com.dd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;



@Controller
public class IndexController {
    @Autowired
    GradeService GS;
    @Autowired
    UserService US;
    @Autowired
    BankService BS;
    //注销并移除session中的user.name
    @RequestMapping("/logout")
    public String logout (HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("name");
        return "login_register";
    }

    //模式一
    @RequestMapping("/selectModel1")
    public ModelAndView model1(
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        ModelAndView mav= new ModelAndView();
        //得到随机20道题目
        List<Bank> rightBank = BS.GetRandomTwentyQuestions(1);
        //将题目和模式存入session
        session.setAttribute("rightBank",rightBank);
        session.setAttribute("model",1);
        //得到uId和times
        Integer uid = US.getIdByName((String) session.getAttribute("name"));
        int times =GS.getNewTime(uid);
        //设置跳转视图和将20道题目和轮数传入Question页面。
        mav.setViewName("Question");
        mav.addObject("Bank1",rightBank);
        mav.addObject("times",times);
        return mav;
    }
    //模式2
    @RequestMapping("/selectModel2")
    public ModelAndView model2(
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        ModelAndView mav= new ModelAndView();
        List<Bank> rightBank = BS.GetRandomTwentyQuestions(2);
        session.setAttribute("rightBank",rightBank);
        session.setAttribute("model",2);
        Integer uid = US.getIdByName((String) session.getAttribute("name"));
        int times =GS.getNewTime(uid);
        mav.setViewName("Question");
        mav.addObject("Bank1",rightBank);
        mav.addObject("times",times);
        return mav;
    }
    //模式三
    @RequestMapping("/selectModel3")
    public ModelAndView model3(
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        ModelAndView mav= new ModelAndView();
        List<Bank> rightBank = BS.GetRandomTwentyQuestions(3);
        session.setAttribute("rightBank",rightBank);
        session.setAttribute("model",3);
        Integer uid = US.getIdByName((String) session.getAttribute("name"));
        int times =GS.getNewTime(uid);
        mav.setViewName("Question");
        mav.addObject("Bank1",rightBank);
        mav.addObject("times",times);
        return mav;
    }
    //统计图
    @RequestMapping("/summary")
    public ModelAndView analyze(
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        ModelAndView mav= new ModelAndView();
        List<Grade> gradeRevise = new ArrayList<>();
        List<Integer> times = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Integer uid = US.getIdByName((String) session.getAttribute("name"));
        //得到该用户的所有成绩信息
        List<Grade> grade =GS.getAllGrade(uid);
        //单独获得grade中的次数和得分，并反转
        for(int i=grade.size()-1;i>=0;i--) {
            times.add(grade.get(i).getTimes());
            result.add(grade.get(i).getResult());
        }
        //将轮数、记录数、得分传入summary（折线图）页面
        mav.addObject("size",times.size());
        mav.addObject("times",times);
        mav.addObject("result",result);
        mav.setViewName("summary");
        return mav;
    }
}
