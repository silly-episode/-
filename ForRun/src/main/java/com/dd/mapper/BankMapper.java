package com.dd.mapper;
import com.dd.entity.Bank;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Repository
@Mapper
public interface BankMapper {
    //查询所有题目，效率低。
    List<Bank> getModelQuestions(@Param("model") Integer model);
}
