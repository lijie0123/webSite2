package com.lijie.webSite1.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by lijie on 2016/5/10.
 */
@Controller
public class WelcomHandler {
    @RequestMapping("")
    public ModelAndView toLogin(HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView();
        if(httpSession.getAttribute("account")==null||httpSession.getAttribute("id")==null||httpSession.getAttribute("id").equals("")){
            modelAndView.setViewName("redirect:/login");
        }else {
            modelAndView.setViewName("redirect:/main/mainPage");
        }
        return modelAndView;
    }
}
