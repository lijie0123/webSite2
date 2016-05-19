package com.lijie.webSite1.api.impl;

import com.lijie.webSite1.api.app.IGradeForTeacherApi;
import com.lijie.webSite1.dao.intr.ICourseRepo;
import com.lijie.webSite1.dao.intr.IStudentCourseRepo;
import com.lijie.webSite1.model.dto.GradeForStudent;
import com.lijie.webSite1.model.dto.GradeForTeacher;
import com.lijie.webSite1.model.entity.CourseVO;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijie on 2016/5/19.
 */
@Service
public class GradeForTeacherApi implements IGradeForTeacherApi {
    @Autowired
    private ICourseRepo courseRepo;
    @Autowired
    private IStudentCourseRepo studentCourseRepo;
    public void updateGrade(String stuId, String courseId, String grade) throws WebException {
        try{
            studentCourseRepo.updateGrade(stuId,courseId,grade);
        }catch (WebException e){
            e.printStackTrace();
            throw e;
        }
    }

    public List<GradeForTeacher> getStudentCourses(String courseId) throws WebException {
        List<CourseVO> courseVOs=null;
        try{
            courseVOs=courseRepo.getCourseVOsByCourseId(courseId);
        }catch (WebException e){
            e.printStackTrace();
            throw e;
        }
        List<GradeForTeacher> gradeForTeachers=new ArrayList<GradeForTeacher>();
        for(CourseVO courseVO:courseVOs ){
            gradeForTeachers.add(GradeForTeacher.toGradeForTeacher(courseVO));
        }
        return gradeForTeachers;
    }
}
