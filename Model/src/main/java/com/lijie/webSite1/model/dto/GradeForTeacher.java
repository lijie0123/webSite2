package com.lijie.webSite1.model.dto;

import com.lijie.webSite1.model.entity.CourseVO;
import com.lijie.webSite1.model.entity.Student;

/**
 * Created by lijie on 2016/5/19.
 */
public class GradeForTeacher {
    private String stuId;
    private String stuName;
    private String courseId;
    private String grade;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "GradeForTeacher{" +
                "stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", courseId='" + courseId + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public static GradeForTeacher toGradeForTeacher(CourseVO courseVO){
        GradeForTeacher gradeForTeacher=new GradeForTeacher();
        gradeForTeacher.setStuId(courseVO.getStuId());
        gradeForTeacher.setStuName(courseVO.getStuName());
        gradeForTeacher.setCourseId(courseVO.getId());
        if(courseVO.getGrade()==null){
            gradeForTeacher.setGrade("");
        }else {
            gradeForTeacher.setGrade(courseVO.getGrade());
        }
        return gradeForTeacher;
    }
}
