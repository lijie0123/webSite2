package com.lijie.webSite1.model.dto;

import com.lijie.webSite1.model.entity.CourseVO;

/**
 * Created by lijie on 2016/5/16.
 */
public class GradeForStudent {
    private String name;
    private String teacherName;
    private String grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "GradeForStudent{" +
                "name='" + name + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public static GradeForStudent toGradeForStudent(CourseVO courseVO){
        GradeForStudent gradeForStudent=new GradeForStudent();
        gradeForStudent.setName(courseVO.getName());
        gradeForStudent.setTeacherName(courseVO.getTeacherName());
        if(courseVO.getGrade()==null){
            gradeForStudent.setGrade("N/A");
        }else {
            gradeForStudent.setGrade(courseVO.getGrade());
        }
        return gradeForStudent;

    }
}
