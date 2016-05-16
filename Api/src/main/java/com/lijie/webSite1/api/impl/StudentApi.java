package com.lijie.webSite1.api.impl;

import com.lijie.webSite1.api.app.IStudentApi;
import com.lijie.webSite1.dao.intr.IStudentRepo;
import com.lijie.webSite1.model.entity.Student;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lijie on 2016/5/15.
 */
@Service
public class StudentApi implements IStudentApi {
    @Autowired
    private IStudentRepo studentRepo;
    public Student getStudentById(String id) throws WebException {
        Student student=null;
        try{
            student=studentRepo.getStudentById(id);
        }catch (WebException e){
            System.out.println(e.toString()+"无法找到ID为"+id+"的学生");
            throw e;
        }
        return student;
    }
}
