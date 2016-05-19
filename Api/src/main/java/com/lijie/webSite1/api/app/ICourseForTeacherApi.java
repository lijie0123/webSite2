package com.lijie.webSite1.api.app;

import com.lijie.webSite1.model.entity.Course;
import com.lijie.webSite1.model.exception.WebException;

import java.util.List;

/**
 * Created by lijie on 2016/5/19.
 */
public interface ICourseForTeacherApi {
    public void addCourse(Course course) throws WebException;
    public List<Course> getAllByTeacherId(String teacherId) throws WebException;
    public void deleteById(String id) throws WebException;
    public Course getCourseById(String id) throws WebException;
}
