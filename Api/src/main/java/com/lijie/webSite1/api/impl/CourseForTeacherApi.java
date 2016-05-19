package com.lijie.webSite1.api.impl;

import com.lijie.webSite1.api.app.ICourseForTeacherApi;
import com.lijie.webSite1.dao.intr.ICourseRepo;
import com.lijie.webSite1.model.entity.Course;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lijie on 2016/5/19.
 */
@Service
public class CourseForTeacherApi implements ICourseForTeacherApi {
    @Autowired
    private ICourseRepo courseRepo;
    public void addCourse(Course course) throws WebException {
        try{
            courseRepo.addCourse(course);
        }catch (WebException e){
            e.printStackTrace();
            throw e;
        }

    }

    public List<Course> getAllByTeacherId(String teacherId) throws WebException {
        try{
            return courseRepo.getAllByTeacherId(teacherId);
        }catch (WebException e){
            e.printStackTrace();
            throw e;
        }
    }

    public void deleteById(String id) throws WebException {
        try{
            courseRepo.deleteById(id);
        }catch (WebException e){
            e.printStackTrace();
            throw e;
        }
    }

    public Course getCourseById(String id) throws WebException {
        try{
            return courseRepo.getCourseById(id);
        }catch (WebException e){
            e.printStackTrace();
            throw e;
        }
    }
}
