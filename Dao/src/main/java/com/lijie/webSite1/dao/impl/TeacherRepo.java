package com.lijie.webSite1.dao.impl;

import com.lijie.webSite1.dao.intr.ITeacherRepo;
import com.lijie.webSite1.model.entity.Student;
import com.lijie.webSite1.model.entity.Teacher;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lijie on 2016/5/19.
 */
@Service
public class TeacherRepo implements ITeacherRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Teacher getTeacherById(String id) throws WebException {
        String sqlString="select * from teacher where id=?";
        List<Teacher> teachers=null;
        try{
            teachers= jdbcTemplate.query(sqlString,new Object[]{id},new TeacherRowMapper());
        }catch (Exception e)
        {
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }
        if(teachers.isEmpty()){
            throw new WebException(100,"记录不存在");
        }else if(teachers.size()>1){
            throw new WebException(101,"记录多行");
        }
        return teachers.get(0);
    }
}
