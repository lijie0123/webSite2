package com.lijie.webSite1.api.impl;

import com.lijie.webSite1.api.app.ITeacherApi;
import com.lijie.webSite1.dao.intr.ITeacherRepo;
import com.lijie.webSite1.model.entity.Teacher;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lijie on 2016/5/19.
 */
@Service
public class TeacherApi implements ITeacherApi{
    @Autowired
    private ITeacherRepo teacherRepo;
    public Teacher getTeacherById(String id) throws WebException {
        try {
            return teacherRepo.getTeacherById(id);
        }catch (WebException e){
            e.printStackTrace();
            throw e;
        }
    }
}
