package com.lijie.webSite1.dao.intr;

import com.lijie.webSite1.model.entity.CourseVO;
import com.lijie.webSite1.model.exception.WebException;

import java.util.List;

/**
 * Created by lijie on 2016/5/16.
 */
public interface ICourseRepo {
    public List<CourseVO> getCourseVOsByStudentId(String stuId)throws WebException;
}
