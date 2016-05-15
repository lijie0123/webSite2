package com.lijie.webSite1.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lijie on 2016/5/10.
 */
@Controller
public class WelcomHandler {
    @RequestMapping("")
    public ModelAndView toLogin(ModelAndView modelAndView){
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }
}
