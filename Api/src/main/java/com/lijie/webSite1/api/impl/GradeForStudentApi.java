package com.lijie.webSite1.api.impl;

import com.lijie.webSite1.api.app.IGradeForStudentApi;
import com.lijie.webSite1.dao.intr.ICourseRepo;
import com.lijie.webSite1.model.dto.CourseForStudent;
import com.lijie.webSite1.model.dto.GradeForStudent;
import com.lijie.webSite1.model.entity.CourseVO;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijie on 2016/5/16.
 */
@Service
public class GradeForStudentApi implements IGradeForStudentApi{
    @Autowired
    private ICourseRepo courseRepo;

    public List<GradeForStudent> getGradeForStudent(String stuId) throws WebException {
        List<CourseVO> courseVOs=null;
        try{
            courseVOs=courseRepo.getCourseVOsByStudentId(stuId);
        }catch (WebException e){
            e.printStackTrace();
            throw e;
        }
        List<GradeForStudent> gradeForStudents=new ArrayList<GradeForStudent>();
        for(CourseVO courseVO:courseVOs ){
            gradeForStudents.add(GradeForStudent.toGradeForStudent(courseVO));
        }
        return gradeForStudents;
    }
}
