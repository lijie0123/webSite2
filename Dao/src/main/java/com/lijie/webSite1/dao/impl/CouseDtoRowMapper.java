package com.lijie.webSite1.dao.impl;

import com.lijie.webSite1.model.entity.CourseVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lijie on 2016/5/16.
 */
public class CouseDtoRowMapper implements RowMapper<CourseVO>{
    @Override
    public CourseVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        CourseVO courseVO =new CourseVO();
        courseVO.setId(rs.getString("id"));
        courseVO.setName(rs.getString("name"));
        courseVO.setDescription(rs.getString("description"));
        courseVO.setStartDate(rs.getDate("startDate"));
        courseVO.setEndDate(rs.getDate("endDate"));
        courseVO.setStuId(rs.getString("stuId"));
        courseVO.setTeacherId(rs.getString("teacherId"));
        courseVO.setGrade(rs.getString("grade"));
        courseVO.setTeacherName(rs.getString("teacherName"));
        return courseVO;
    }
}
