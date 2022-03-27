package com.dd.service;
import com.dd.entity.Bank;

import java.util.List;

public interface BankService {
    //通过model得到对应的题目
    List<Bank> GetRandomTwentyQuestions(Integer Model);
    //传入2组题目比对答案
    List<Integer> ForTheAnswer(List<Bank> rightBank,List<Bank> StudentBank,Integer Model);
}
