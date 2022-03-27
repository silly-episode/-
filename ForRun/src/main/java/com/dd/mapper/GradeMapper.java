package com.dd.mapper;
import com.dd.entity.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GradeMapper {
    //得到所有成绩，用List接收
    List<Grade> getAllGrade(@Param("uId") Integer uid);
    //插入一个成绩，insert,不能用@Param注解
    int insertGrade(Grade grade);
    //得到最后一次成绩
    Grade getLastGrade(@Param("uId") Integer uid);
    //得到记录条数
    int getTotalNumber(@Param("uId") Integer uId);
}
