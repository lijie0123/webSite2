package com.lijie.webSite1.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lijie on 2016/5/10.
 */
@Controller
public class WelcomHandler {
    @RequestMapping("")
    public String toLogin(){
        return "redirect;/login";
    }
}
