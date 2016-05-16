package com.lijie.webSite1.dao.impl;

import com.lijie.webSite1.dao.intr.ICourseRepo;
import com.lijie.webSite1.model.entity.CourseVO;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lijie on 2016/5/16.
 */
@Repository
public class CourseRepo implements ICourseRepo{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<CourseVO> getCourseVOsByStudentId(String stuId) throws WebException{
        String sqlString="select student_course.stuId as stuId,student_course.grade as grade, course.id as id,course.name as name,course.teacherId as teacherId,course.description as description, course.startDate as startDate,course.endDate as endDate,teacher.name as teacherName from student_course,course,teacher where student_course.stuId=? and student_course.courseId=course.id and course.teacherId=teacher.id";
        List<CourseVO> courseVOs =null;
        try{
            courseVOs = jdbcTemplate.query(sqlString,new Object[]{stuId},new CouseDtoRowMapper());
        }catch (Exception e)
        {
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }

        return courseVOs;
    }
}
