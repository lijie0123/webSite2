package com.lijie.webSite1.api.app;

import com.lijie.webSite1.model.dto.CourseForStudent;
import com.lijie.webSite1.model.exception.WebException;

import java.util.List;

/**
 * Created by lijie on 2016/5/16.
 */
public interface ICourseForStudentApi {
    public List<CourseForStudent> getCoursesByStudentId(String stuId) throws WebException;
}
