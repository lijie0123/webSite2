package com.lijie.webSite1.controler;

import com.lijie.webSite1.model.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by lijie on 2016/5/10.
 */
@Controller
@RequestMapping("main")
public class MainPageHandler {
    @RequestMapping("mainPage")
    public ModelAndView cMain(HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("mainPage");
        modelAndView.addObject("sessionId",httpSession.getAttribute("id").toString());
        modelAndView.addObject("accountType",((Account)httpSession.getAttribute("account")).getAccountType().toString());
        return modelAndView;
    }
}
