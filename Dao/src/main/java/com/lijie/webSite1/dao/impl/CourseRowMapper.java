package com.lijie.webSite1.dao.impl;

import com.lijie.webSite1.model.entity.Course;
import com.lijie.webSite1.model.entity.CourseVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lijie on 2016/5/19.
 */
public class CourseRowMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        Course course =new Course();
        course.setId(rs.getString("id"));
        course.setName(rs.getString("name"));
        course.setDescription(rs.getString("description"));
        course.setStartDate(rs.getDate("startDate"));
        course.setEndDate(rs.getDate("endDate"));
        course.setTeacherId(rs.getString("teacherId"));
        return course;
    }
}
