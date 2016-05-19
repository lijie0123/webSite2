package com.lijie.webSite1.dao.intr;

import com.lijie.webSite1.model.exception.WebException;

/**
 * Created by lijie on 2016/5/19.
 */
public interface IStudentCourseRepo {
    public void updateGrade(String stuId, String courseId, String grade) throws WebException;
}
