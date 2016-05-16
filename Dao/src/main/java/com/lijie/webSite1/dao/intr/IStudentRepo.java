package com.lijie.webSite1.dao.intr;

import com.lijie.webSite1.model.entity.Student;
import com.lijie.webSite1.model.exception.WebException;

/**
 * Created by lijie on 2016/5/15.
 */
public interface IStudentRepo {
    public Student getStudentById(String id)throws WebException;
    public void addStudent(Student student)throws WebException;
    public void delStudentById(String id)throws WebException;
    public void updateStudent(Student student)throws WebException;
}
