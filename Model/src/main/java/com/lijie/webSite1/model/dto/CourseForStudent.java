package com.lijie.webSite1.model.dto;

import com.lijie.webSite1.model.entity.CourseVO;

import java.util.Date;

/**
 * Created by lijie on 2016/5/16.
 */
public class CourseForStudent {
    private String name;
    private Date startDate;
    private Date endDate;
    private String teacherName;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CourseForStudent{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", teacherName='" + teacherName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    public static CourseForStudent toCourseForStudent(CourseVO courseVO){
        CourseForStudent courseForStudent=new CourseForStudent();
        courseForStudent.setName(courseVO.getName());
        courseForStudent.setTeacherName(courseVO.getTeacherName());
        courseForStudent.setDescription(courseVO.getDescription());
        courseForStudent.setStartDate(courseVO.getStartDate());
        courseForStudent.setEndDate(courseVO.getEndDate());
        return courseForStudent;
    }

}
