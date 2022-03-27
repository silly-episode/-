package com.dd.service.impl;
import com.dd.entity.Grade;
import com.dd.mapper.GradeMapper;
import com.dd.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("GradeServiceImpl")
public  class GradeServiceImpl implements GradeService {
    @Autowired
    GradeMapper gradeMapper;
    @Override
    public Grade getLastGrade(Integer uId) {
        return gradeMapper.getLastGrade(uId);
    }
    @Override
    public List<Grade> getAllGrade(Integer uId) {
       return gradeMapper.getAllGrade(uId);
    }
    @Override
    public int insertGrade(Grade grade) {
        return gradeMapper.insertGrade(grade);
    }
    @Override
    public int getNewTime(Integer uId) {
        return gradeMapper.getTotalNumber(uId)+1;
    }
}
