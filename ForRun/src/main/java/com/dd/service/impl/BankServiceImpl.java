package com.dd.service.impl;
import com.dd.entity.Bank;
import com.dd.mapper.BankMapper;
import com.dd.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service("BankServiceImpl")
public  class BankServiceImpl  implements BankService {
    @Autowired
    private BankMapper bankMapper;
    final int number = 20;
    //比对成绩
    @Override
    public List<Integer> ForTheAnswer(List<Bank> rightBank, List<Bank> StudentBank,Integer Model) {
        List<Integer> situation = new ArrayList<>();
        //比对答案，如果正确则添加1
        for(int i=0;i<number;i++) {
            if(rightBank.get(i).getAnswer().equals(StudentBank.get(i).getAnswer())){
                situation.add(1);
            }
            else {
                situation.add(0);
            }
        }
        return situation;
    }
    //通过模式数，获得20道题目
    @Override
    public  List<Bank> GetRandomTwentyQuestions(Integer Model) {
        int totalNumber=19;
        int randomint=0;
        //random是random类
        Random random = new Random();
        //是数据库取出的该模式所有题目
        List<Bank> allQuestions =  bankMapper.getModelQuestions(Model);
        //记录随机20道题目
        List<Bank> twentyQuestions = new ArrayList<>();
        //记录20个不同的随机数
        List n=new ArrayList<>();
        //记录取出的题目数量
        int allQuestionsNum=allQuestions.size();
        while (totalNumber>=0)
         {
             //产生0到allQuestionsNum-1的随机数
            randomint=random.nextInt(allQuestionsNum);
           if(n.contains(randomint)) {
               continue;
           }
           else {
               n.add(randomint);
               totalNumber--;
           }
        }
        //通过一组不重复的20个随机数添加题目到twentyQuestions
        for (Object x : n) {
            twentyQuestions.add(allQuestions.get( (int) x ));
        }
        return twentyQuestions;
    }
}


