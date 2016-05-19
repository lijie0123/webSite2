package com.lijie.webSite1.api.app;

import com.lijie.webSite1.model.entity.Teacher;
import com.lijie.webSite1.model.exception.WebException;

/**
 * Created by lijie on 2016/5/19.
 */
public interface ITeacherApi {
    public Teacher getTeacherById(String id) throws WebException;
}
