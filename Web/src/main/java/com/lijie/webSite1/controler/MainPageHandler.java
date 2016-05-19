package com.lijie.webSite1.controler;

import com.lijie.webSite1.api.app.*;
import com.lijie.webSite1.dao.intr.ITeacherRepo;
import com.lijie.webSite1.model.dto.CourseForStudent;
import com.lijie.webSite1.model.dto.GradeForStudent;
import com.lijie.webSite1.model.dto.GradeForTeacher;
import com.lijie.webSite1.model.entity.*;
import com.lijie.webSite1.model.enumeration.AccountType;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private ITeacherApi teacherApi;
    @Autowired
    private ICourseForStudentApi courseForStudentApi;
    @Autowired
    private ICourseForTeacherApi courseForTeacherApi;
    @Autowired
    private IGradeForStudentApi gradeForStudentApi;
    @Autowired
    private INewsApi newsApi;
    @Autowired
    private IGradeForTeacherApi gradeForTeacherApi;

    @RequestMapping("mainPage")
    public ModelAndView cMain(HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView();
        Account account=(Account)httpSession.getAttribute("account");
        modelAndView.setViewName("mainPage");
        if(account.getAccountType()== AccountType.STUDENT){
            return cStudentMain(modelAndView,httpSession);
        }else if(account.getAccountType()==AccountType.TEACHER){
            return cTacherMain(modelAndView,httpSession);
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

    private ModelAndView cTacherMain(ModelAndView modelAndView, HttpSession httpSession){
        modelAndView.setViewName("teacherMain");
        Account account= (Account) httpSession.getAttribute("account");
        Teacher teacher=null;
        try{
            teacher=getTeacherAndHandleException(modelAndView,account.getAssociateId());
        }catch (Exception e){
            return modelAndView;
        }
        modelAndView.addObject("name",teacher.getName());
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

    @RequestMapping("teacherInfo")
    public ModelAndView cTeacherInfo(HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView();
        Account account= (Account) httpSession.getAttribute("account");
        Teacher teacher=null;
        try{
            teacher=getTeacherAndHandleException(modelAndView,account.getAssociateId());
        }catch (Exception e){
            return modelAndView;
        }
        modelAndView.setViewName("teacherInfo");
        modelAndView.addObject("accountId",account.getId());
        modelAndView.addObject("name",teacher.getName());
        modelAndView.addObject("stuId",teacher.getId());
        modelAndView.addObject("sex",teacher.getSex().toString());
        modelAndView.addObject("birthday",teacher.getBirthday().toString());
        modelAndView.addObject("title",teacher.getTitle());
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

    @RequestMapping("teacherCourse")
    public ModelAndView cTeacherCourse(HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView();
        Account account=(Account)httpSession.getAttribute("account");
        Teacher teacher=null;
        List<Course> courses=null;
        try{
            teacher=getTeacherAndHandleException(modelAndView,account.getAssociateId());
        }catch (Exception e){
            return modelAndView;
        }
        try {
            courses=courseForTeacherApi.getAllByTeacherId(teacher.getId());
        }catch (WebException e){
            modelAndView.setViewName("/errorPage");
            modelAndView.addObject("info",e.toString());
            return modelAndView;
        }

        modelAndView.setViewName("teacherCourse");
        modelAndView.addObject("courses",courses);
        return modelAndView;
    }

    @RequestMapping("deleteCourseById")
    public ModelAndView cDeleteCourseById(HttpSession httpSession, @RequestParam("id") String courseId){
        ModelAndView modelAndView=new ModelAndView();
        Account account=(Account)httpSession.getAttribute("account");
        Teacher teacher=null;
        Course course=null;
        try{
            teacher=getTeacherAndHandleException(modelAndView,account.getAssociateId());
        }catch (Exception e){
            return modelAndView;
        }
        try {
            course=courseForTeacherApi.getCourseById(courseId);
        }catch (WebException e){
            modelAndView.setViewName("/errorPage");
            modelAndView.addObject("info",e.toString());
            return modelAndView;
        }
        if(!course.getTeacherId().equals(teacher.getId())){
            modelAndView.setViewName("/errorPage");
            modelAndView.addObject("info","你不是该课程的授课老师");
            return modelAndView;
        }
        try{
            courseForTeacherApi.deleteById(courseId);
        } catch (WebException e) {
            modelAndView.setViewName("/errorPage");
            modelAndView.addObject("info",e.toString());
            return modelAndView;
        }

        modelAndView.setViewName("redirect:teacherCourse");
        return modelAndView;
    }

    @RequestMapping("addCourse")
    public ModelAndView cDeleteCourseById(HttpSession httpSession, @RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) throws ParseException {
        ModelAndView modelAndView=new ModelAndView();
        Account account=(Account)httpSession.getAttribute("account");
        Teacher teacher=null;
        Course course=null;
        try{
            teacher=getTeacherAndHandleException(modelAndView,account.getAssociateId());
        }catch (Exception e){
            return modelAndView;
        }
        course=new Course();
        course.setId(id);
        course.setName(name);
        course.setTeacherId(teacher.getId());
        course.setDescription(description);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try{
            course.setStartDate(simpleDateFormat.parse(startDate));
            System.out.println(simpleDateFormat.parse(startDate).getTime());
            course.setEndDate(simpleDateFormat.parse(endDate));
        }catch (ParseException e){
            modelAndView.setViewName("/errorPage");
            modelAndView.addObject("info","日期格式错误"+e.toString());
            return modelAndView;
        }
        try {
            courseForTeacherApi.addCourse(course);
        } catch (WebException e) {
            modelAndView.setViewName("/errorPage");
            modelAndView.addObject("info",e.toString());
            return modelAndView;
        }
        modelAndView.setViewName("redirect:teacherCourse");
        return modelAndView;
    }

    @RequestMapping("studentNews")
    public ModelAndView cStudentNews(HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView();
        Account account=(Account)httpSession.getAttribute("account");
        Student student=null;
        List<News> newses=null;
        try{
            student=getStudentAndHandleException(modelAndView,account.getAssociateId());
        }catch (Exception e){
            return modelAndView;
        }
        try {
            newses=newsApi.getAll();
        }catch (WebException e){
            modelAndView.setViewName("/errorPage");
            modelAndView.addObject("info",e.toString());
            return modelAndView;
        }

        modelAndView.setViewName("studentNews");
        modelAndView.addObject("newses",newses);
        return modelAndView;

    }
    @RequestMapping("teacherNews")
    public ModelAndView cTeacherNews(HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView();
        Account account=(Account)httpSession.getAttribute("account");
        Teacher teacher=null;
        List<News> newses=null;
        try{
            teacher=getTeacherAndHandleException(modelAndView,account.getAssociateId());
        }catch (Exception e){
            return modelAndView;
        }
        try {
            newses=newsApi.getAll();
        }catch (WebException e){
            modelAndView.setViewName("/errorPage");
            modelAndView.addObject("info",e.toString());
            System.out.println("");
            return modelAndView;
        }

        modelAndView.setViewName("teacherNews");
        modelAndView.addObject("newses",newses);
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

    @RequestMapping("teacherGrade")
    public ModelAndView cTeacherGrade(HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView();
        Account account=(Account)httpSession.getAttribute("account");
        Teacher teacher=null;
        List<Course> courses=null;
        try{
            teacher=getTeacherAndHandleException(modelAndView,account.getAssociateId());
        }catch (Exception e){
            return modelAndView;
        }
        try {
            courses=courseForTeacherApi.getAllByTeacherId(teacher.getId());
        }catch (WebException e){
            modelAndView.setViewName("/errorPage");
            modelAndView.addObject("info",e.toString());
            return modelAndView;
        }

        modelAndView.setViewName("teacherGrade");
        modelAndView.addObject("courses",courses);
        return modelAndView;
    }

    @RequestMapping("teacherGradeIndex")
    public ModelAndView cTeacherGradeIndex(HttpSession httpSession, @RequestParam("courseId") String courseId){
        ModelAndView modelAndView=new ModelAndView();
        Account account=(Account)httpSession.getAttribute("account");
        Teacher teacher=null;
        Course course=null;
        List<CourseVO> courses=null;
        try{
            teacher=getTeacherAndHandleException(modelAndView,account.getAssociateId());
        }catch (Exception e){
            return modelAndView;
        }
        try {
            course=courseForTeacherApi.getCourseById(courseId);
        }catch (WebException e){
            modelAndView.setViewName("/errorPage");
            modelAndView.addObject("info",e.toString());
            return modelAndView;
        }
        List<GradeForTeacher> gradeForTeachers=null;
        try{
            gradeForTeachers=gradeForTeacherApi.getStudentCourses(courseId);
        }catch (WebException e){
            modelAndView.setViewName("/errorPage");
            modelAndView.addObject("info",e.toString());
            return modelAndView;
        }
        modelAndView.setViewName("teacherGradeIndex");
        modelAndView.addObject("courseName",course.getName());
        modelAndView.addObject("courseId",course.getId());
        modelAndView.addObject("gradeForTeachers",gradeForTeachers);
        return modelAndView;
    }
    @RequestMapping("updateGrade")
    public ModelAndView cUpdateGrade(HttpSession httpSession, @RequestParam("stuId") String stuId, @RequestParam("courseId") String courseId, @RequestParam("grade") String grade){
        ModelAndView modelAndView=new ModelAndView();
        Account account=(Account)httpSession.getAttribute("account");
        Teacher teacher=null;
        Course course=null;
        List<CourseVO> courses=null;
        try{
            teacher=getTeacherAndHandleException(modelAndView,account.getAssociateId());
        }catch (Exception e){
            return modelAndView;
        }
        try {
            course=courseForTeacherApi.getCourseById(courseId);
        }catch (WebException e){
            modelAndView.setViewName("/errorPage");
            modelAndView.addObject("info",e.toString());
            return modelAndView;
        }
        if(!course.getTeacherId().equals(teacher.getId())){
            modelAndView.setViewName("/errorPage");
            modelAndView.addObject("info","你不是该课程的授课老师");
            return modelAndView;
        }
        try{
            gradeForTeacherApi.updateGrade(stuId,courseId,grade);
        }catch (WebException e){
            modelAndView.setViewName("/errorPage");
            modelAndView.addObject("info",e.toString());
            return modelAndView;
        }
        modelAndView.setViewName("redirect:teacherGradeIndex?courseId="+courseId);
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

    private Teacher getTeacherAndHandleException(ModelAndView modelAndView, String id) throws Exception{
        Teacher teacher=null;
        try{
            teacher=teacherApi.getTeacherById(id);
        } catch (WebException e) {
            if(e.getCode()==100||e.getCode()==101){
                modelAndView.setViewName("/errorPage");
                modelAndView.addObject("info","你的教师信息有误，请联系教务");
                throw new Exception(e);
            }else {
                modelAndView.setViewName("/errorPage");
                modelAndView.addObject("info",e.toString());
                throw new Exception(e);
            }
        }
        return teacher;
    }


}
