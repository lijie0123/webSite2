package com.lijie.webSite1.api.app;

import com.lijie.webSite1.model.entity.Student;
import com.lijie.webSite1.model.exception.WebException;

/**
 * Created by lijie on 2016/5/15.
 */
public interface IStudentApi {
    public Student getStudentById(String id)throws WebException;
}
