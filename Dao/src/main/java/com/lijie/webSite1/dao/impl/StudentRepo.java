package com.lijie.webSite1.dao.impl;

import com.lijie.webSite1.dao.intr.IStudentRepo;
import com.lijie.webSite1.model.entity.Student;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lijie on 2016/5/15.
 */
@Repository
public class StudentRepo implements IStudentRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Student getStudentById(String id) throws WebException {
        String sqlString="select * from student where id=?";
        List<Student> students=null;
        try{
            students= jdbcTemplate.query(sqlString,new Object[]{id},new StudentRowMapper());
        }catch (Exception e)
        {
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }
        if(students.isEmpty()){
            throw new WebException(100,"记录不存在");
        }else if(students.size()>1){
            throw new WebException(101,"记录多行");
        }
        return students.get(0);
    }

    @Override
    public void addStudent(Student student) throws WebException {
        String sqlString="insert into student(id, name, sex, birthday, moveInDay) values(?,?,?,?,?)";
        try{
            jdbcTemplate.update(sqlString,student.getId(),student.getName(),student.getSex().getValue(),student.getBirthday(),student.getMoveInDay());
        }catch (Exception e){
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }
    }

    @Override
    public void delStudentById(String id) throws WebException {
        String sqlString="delete from student where id=?";
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
    public void updateStudent(Student student) throws WebException {
//TODO
    }
}
