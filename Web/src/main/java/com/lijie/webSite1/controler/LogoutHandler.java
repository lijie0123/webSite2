package com.lijie.webSite1.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by lijie on 2016/5/15.
 */
@Controller
@RequestMapping("logout")
public class LogoutHandler {
    @RequestMapping
    public String cLogout(HttpSession httpSession){
        httpSession.removeAttribute("id");
        httpSession.removeAttribute("account");
        return "redirect:/login";
    }

}
