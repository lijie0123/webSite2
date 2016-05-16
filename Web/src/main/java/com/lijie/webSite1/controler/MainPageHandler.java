package com.lijie.webSite1.controler;

import com.lijie.webSite1.api.app.ICourseForStudentApi;
import com.lijie.webSite1.api.app.IGradeForStudentApi;
import com.lijie.webSite1.api.app.IStudentApi;
import com.lijie.webSite1.model.dto.CourseForStudent;
import com.lijie.webSite1.model.dto.GradeForStudent;
import com.lijie.webSite1.model.entity.Account;
import com.lijie.webSite1.model.entity.Student;
import com.lijie.webSite1.model.enumeration.AccountType;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by lijie on 2016/5/10.
 */
@Controller
@RequestMapping("main")
public class MainPageHandler {
    @Autowired
    private IStudentApi studentApi;
    @Autowired
    private ICourseForStudentApi courseForStudentApi;
    @Autowired
    private IGradeForStudentApi gradeForStudentApi;

    @RequestMapping("mainPage")
    public ModelAndView cMain(HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView();
        Account account=(Account)httpSession.getAttribute("account");
        modelAndView.setViewName("mainPage");
        if(account.getAccountType()== AccountType.STUDENT){
            return cStudentMain(modelAndView,httpSession);
        }

        modelAndView.addObject("sessionId",httpSession.getAttribute("id").toString());
        modelAndView.addObject("accountType",((Account)httpSession.getAttribute("account")).getAccountType().toString());
        return modelAndView;
    }

    private ModelAndView cStudentMain(ModelAndView modelAndView, HttpSession httpSession){
        modelAndView.setViewName("studentMain");
        Account account= (Account) httpSession.getAttribute("account");
        Student student=null;
        try{
            student=getStudentAndHandleException(modelAndView,account.getAssociateId());
        }catch (Exception e){
            return modelAndView;
        }
        modelAndView.addObject("name",student.getName());
        return modelAndView;
    }

    @RequestMapping("studentInfo")
    public ModelAndView cStudentInfo(HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView();
        Account account=(Account)httpSession.getAttribute("account");
        Student student=null;
        try{
            student=getStudentAndHandleException(modelAndView,account.getAssociateId());
        }catch (Exception e){
            return modelAndView;
        }
        modelAndView.setViewName("studentInfo");
        modelAndView.addObject("accountId",account.getId());
        modelAndView.addObject("name",student.getName());
        modelAndView.addObject("stuId",student.getId());
        modelAndView.addObject("sex",student.getSex().toString());
        modelAndView.addObject("birthday",student.getBirthday().toString());
        modelAndView.addObject("moveInDay",student.getMoveInDay());
        return modelAndView;
    }

    @RequestMapping("studentCourse")
    public ModelAndView cStudentCourse(HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView();
        Account account=(Account)httpSession.getAttribute("account");
        Student student=null;
        List<CourseForStudent> courseForStudents=null;
        try{
            student=getStudentAndHandleException(modelAndView,account.getAssociateId());
        }catch (Exception e){
            return modelAndView;
        }
        try {
            courseForStudents=courseForStudentApi.getCoursesByStudentId(student.getId());
        }catch (WebException e){
            modelAndView.setViewName("/errorPage");
            modelAndView.addObject("info",e.toString());
            return modelAndView;
        }

        modelAndView.setViewName("studentCourse");
        modelAndView.addObject("courses",courseForStudents);
        return modelAndView;

    }

    @RequestMapping("studentGrade")
    public ModelAndView cStudentGrade(HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView();
        Account account=(Account)httpSession.getAttribute("account");
        Student student=null;
        List<GradeForStudent> gradeForStudents=null;
        try{
            student=getStudentAndHandleException(modelAndView,account.getAssociateId());
        }catch (Exception e){
            return modelAndView;
        }
        try {
            gradeForStudents=gradeForStudentApi.getGradeForStudent(student.getId());
        }catch (WebException e){
            modelAndView.setViewName("/errorPage");
            modelAndView.addObject("info",e.toString());
            return modelAndView;
        }

        modelAndView.setViewName("studentGrade");
        modelAndView.addObject("grades",gradeForStudents);
        return modelAndView;

    }

    private Student getStudentAndHandleException(ModelAndView modelAndView, String id) throws Exception{
        Student student=null;
        try{
            student=studentApi.getStudentById(id);
        } catch (WebException e) {
            if(e.getCode()==100||e.getCode()==101){
                modelAndView.setViewName("/errorPage");
                modelAndView.addObject("info","你的学生信息有误，请联系教务");
                throw new Exception(e);
            }else {
                modelAndView.setViewName("/errorPage");
                modelAndView.addObject("info",e.toString());
                throw new Exception(e);
            }
        }
        return student;
    }


}
