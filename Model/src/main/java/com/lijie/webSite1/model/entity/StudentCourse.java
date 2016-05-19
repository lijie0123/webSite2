package com.lijie.webSite1.model.entity;

/**
 * Created by lijie on 2016/5/19.
 */
public class StudentCourse {
    private String stdId;
    private String courseId;
    private String grade;

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
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
        return "StudentCourse{" +
                "stdId='" + stdId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
