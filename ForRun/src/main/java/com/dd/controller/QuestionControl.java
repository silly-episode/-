package com.dd.controller;
import com.dd.entity.*;
import com.dd.service.BankService;
import com.dd.service.GradeService;
import com.dd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class QuestionControl {
    @Autowired
    BankService BS;
    @Autowired
    GradeService GS;
    @Autowired
    UserService US;

    @RequestMapping (value = "/submitAnswer",consumes = "application/json" ,method = RequestMethod.POST)
    @ResponseBody
    //使用List<Bank>来接受ajax中传的json数据。
    public Map submitAnswer(HttpServletRequest request, @RequestBody List<Bank> studentBank) {
        HttpSession session = request.getSession();
        int score=0;
        int times=0;
        Grade newGrade =new Grade();
        Map map  = new HashMap();
        //取得session中的正确题目
        List<Bank> rightBank = (List<Bank>) session.getAttribute("rightBank");
        //传入正确题目和学生题目得到正确情况，1为对，0为错
        List<Integer> situation =BS.ForTheAnswer(rightBank,studentBank,0);
        //得到分数
        Integer uid = US.getIdByName((String) session.getAttribute("name"));
        times= GS.getNewTime(uid);
        //计算得分，答对一道加5分，满分100分
        for (Integer integer : situation) {
            if(integer==1) {
                score=score+5;
            }
        }
        //将uId，得分，轮数插入数据库
        newGrade.setUId(uid);
        newGrade.setResult(score);
        newGrade.setTimes(times);
        GS.insertGrade(newGrade);
        //将得分、对错情况、正确题目、学生题目、轮数写入session
        session.setAttribute("score",score);
        session.setAttribute("situation",situation);
        session.setAttribute("studentBank",studentBank);
        session.setAttribute("rightBank",rightBank);
        session.setAttribute("times",times);
        map.put("code","1");
        return map;
        //ajax为异步，返回数据到原url，无法使用ModelAndView、return “” 来进行页面跳转，
        // 此处使用ajax回调函数 ：
/*        success:function (data2) {
            if(data2.code == "1") {
                window.location.href="http://localhost:8080/FourRun_war_exploded/Answer";
            }
            else {
                alert("提交失败，请稍后再试");
            }
        },
*/

    }
}
