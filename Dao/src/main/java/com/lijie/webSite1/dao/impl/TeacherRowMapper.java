package com.lijie.webSite1.dao.impl;

import com.lijie.webSite1.model.entity.Student;
import com.lijie.webSite1.model.entity.Teacher;
import com.lijie.webSite1.model.enumeration.Sex;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lijie on 2016/5/19.
 */
public class TeacherRowMapper implements RowMapper<Teacher> {
    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        Teacher teacher=new Teacher();
        teacher.setId(rs.getString("id"));
        teacher.setName(rs.getString("name"));
        teacher.setSex(Sex.toSex(rs.getInt("sex")));
        teacher.setBirthday(rs.getDate("birthday"));
        teacher.setTitle(rs.getString("title"));
        return teacher;
    }
}