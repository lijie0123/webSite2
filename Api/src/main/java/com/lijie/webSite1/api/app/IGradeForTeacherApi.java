package com.lijie.webSite1.api.app;

import com.lijie.webSite1.model.dto.GradeForTeacher;
import com.lijie.webSite1.model.exception.WebException;

import java.util.List;

/**
 * Created by lijie on 2016/5/19.
 */
public interface IGradeForTeacherApi {
    public void updateGrade(String stuId, String courseId, String grade) throws WebException;
    public List<GradeForTeacher> getStudentCourses(String courseId) throws WebException;
}
