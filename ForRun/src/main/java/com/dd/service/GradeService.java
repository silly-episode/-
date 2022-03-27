package com.dd.service;
import com.dd.entity.Grade;

import java.util.List;

public interface GradeService {

    Grade getLastGrade(Integer uId);

    List<Grade> getAllGrade(Integer uId);

    int insertGrade(Grade grade);

    int getNewTime(Integer uId);
}
