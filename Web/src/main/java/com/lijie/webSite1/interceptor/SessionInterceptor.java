package com.lijie.webSite1.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lijie on 2016/5/15.
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("---interceptor is running---");
        if(request.getSession().getAttribute("id")==null||request.getSession().getAttribute("id").equals("")){
            System.out.println("---jump to login page---");
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }else {
            return true;
        }
    }
}
