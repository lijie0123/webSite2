package com.lijie.webSite1.dao.impl;

import com.lijie.webSite1.dao.intr.ICourseRepo;
import com.lijie.webSite1.model.entity.Account;
import com.lijie.webSite1.model.entity.Course;
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

    @Override
    public void addCourse(Course course) throws WebException {
        String sqlString="insert into course(id, name, teacherId, description, startDate, endDate) values(?,?,?,?,?,?)";
        try{
            jdbcTemplate.update(sqlString,course.getId(),course.getName(),course.getTeacherId(),course.getDescription(),course.getStartDate(),course.getEndDate());
        }catch (Exception e){
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }
    }

    @Override
    public List<Course> getAllByTeacherId(String teacherId) throws WebException {
        List<Course> courses=null;
        String sqlString="select * from course where teacherId=?;";
        try{
            courses=jdbcTemplate.query(sqlString,new Object[]{teacherId},new CourseRowMapper());
        }catch (Exception e){
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }
        return courses;
    }

    @Override
    public void deleteById(String id) throws WebException {
        String sqlString="delete from course where id=?";
        int affectedRow=0;
        try{
            affectedRow=jdbcTemplate.update(sqlString,id);
        }catch (Exception e){
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }
        if(affectedRow==0){
            throw new WebException(102,"未删除一行");
        }
        else if(affectedRow>1){
            throw new WebException(103,"删除多行");
        }
    }

    @Override
    public Course getCourseById(String id) throws WebException {
        String sqlString="select * from course where id=?";
        List<Course> courses=null;
        try{
            courses= jdbcTemplate.query(sqlString,new Object[]{id},new CourseRowMapper());
        }catch (Exception e)
        {
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }
        if(courses.isEmpty()){
            throw new WebException(100,"记录不存在");
        }else if(courses.size()>1){
            throw new WebException(101,"记录多行");
        }
        return courses.get(0);
    }

}
