package com.lijie.webSite1.dao.impl;

import com.lijie.webSite1.model.entity.Student;
import com.lijie.webSite1.model.enumeration.Sex;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lijie on 2016/5/15.
 */
public class StudentRowMapper implements RowMapper{
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student=new Student();
        student.setId(rs.getString("id"));
        student.setName(rs.getString("name"));
        student.setSex(Sex.toSex(rs.getInt("sex")));
        student.setBirthday(rs.getDate("birthday"));
        student.setMoveInDay(rs.getDate("moveInDay"));
        return student;
    }
}
