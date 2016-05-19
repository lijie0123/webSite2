package com.lijie.webSite1.dao.impl;

import com.lijie.webSite1.dao.intr.IStudentCourseRepo;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by lijie on 2016/5/19.
 */
@Service
public class StudentCourseRepo implements IStudentCourseRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void updateGrade(String stuId, String courseId, String grade) throws WebException {
        String sqlString="update student_course set grade=? where stuId=? and courseId=? ";
        int affectedRow=0;
        try{
            affectedRow=jdbcTemplate.update(sqlString,grade,stuId,courseId);
        }catch (Exception e){
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }
        if(affectedRow==0){
            throw new WebException(104,"未影响一行");
        }
        else if(affectedRow>1){
            throw new WebException(105,"影响多行");
        }
    }
}
