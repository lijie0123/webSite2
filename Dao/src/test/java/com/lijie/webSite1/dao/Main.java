package com.lijie.webSite1.dao;

import com.lijie.webSite1.dao.impl.AccountRepo;
import com.lijie.webSite1.dao.intr.IAccountRepo;
import com.lijie.webSite1.dao.intr.ICourseRepo;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lijie on 2016/5/14.
 */
public class Main {
    public static void main(String arg[]){
        ApplicationContext ac=new ClassPathXmlApplicationContext("daoTest.xml");
        ICourseRepo courseRepo= (ICourseRepo) ac.getBean("courseRepo");
        try{
            System.out.println(courseRepo.getCourseVOsByStudentId("12345").toString());
        }catch (WebException e){
            e.printStackTrace();
        }
    }
}
