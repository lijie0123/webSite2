package com.lijie.webSite1.controler;

import com.lijie.webSite1.api.app.IAccountApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by lijie on 2016/5/10.
 */
@Controller
@RequestMapping("login")
public class LoginHandler {
    @Autowired
    private IAccountApi accountApi;

    @RequestMapping
    public ModelAndView cWelcom(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        Map map=request.getParameterMap();
        if(map.containsKey("errorRelogin")){
            modelAndView.addObject("loginErrorShow","");
            modelAndView.addObject("noLoginErrorShow","hidden");
        }
        else{
            modelAndView.addObject("loginErrorShow","hidden");
            modelAndView.addObject("noLoginErrorShow","");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @RequestMapping("login")
    public String cLogin(@RequestParam("id") String id, @RequestParam("passwd") String passwd, HttpSession httpSession, RedirectAttributes redirectAttributes){
        if(accountApi.isAccountValid(id,passwd)){
            httpSession.setAttribute("id",id);
            httpSession.setAttribute("account",accountApi.getAccountById(id));
            return "redirect:/main/mainPage";
        }
        else{
            redirectAttributes.addAttribute("errorRelogin","1");
            return "redirect:/login";
        }
    }

}
