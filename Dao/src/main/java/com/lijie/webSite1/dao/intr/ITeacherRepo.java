package com.lijie.webSite1.dao.intr;

import com.lijie.webSite1.model.entity.Teacher;
import com.lijie.webSite1.model.exception.WebException;

/**
 * Created by lijie on 2016/5/19.
 */
public interface ITeacherRepo {
    public Teacher getTeacherById(String id)throws WebException;
}
