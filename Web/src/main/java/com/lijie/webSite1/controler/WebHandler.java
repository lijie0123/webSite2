package com.lijie.webSite1.controler;

import com.lijie.webSite1.api.app.IPersonApi;
import com.lijie.webSite1.model.dto.PersonDto;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lj on 16-3-5.
 */
@Controller
@RequestMapping("/person")
public class WebHandler {
    @Autowired
    private IPersonApi personApi;

    @RequestMapping("welcomePage")
    public ModelAndView conIndex(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView("welcome");
        modelAndView.addObject("title",request.getRequestURI());
        return modelAndView;
    }
    @RequestMapping("savePerson")
    public ModelAndView conSavePerson(@RequestParam("id") int id, @RequestParam("name") String name,@RequestParam("sex") String sex,
                              @RequestParam("age") int age, @RequestParam("desc") String desc){
        PersonDto personDto=new PersonDto(id,name,sex,age,desc);
        try{
            personApi.savePerson(personDto);
        }catch (WebException e){
            System.out.println(e.toString());
            e.printStackTrace();
            return new ModelAndView("errorPage","info",e.toString());
        }
        return new ModelAndView("redirect:getAll");
    }
    @RequestMapping("getAll")
    public ModelAndView conGetAll(){
        List<PersonDto> personDtos = null;
        try{
            personDtos=personApi.getAll();
        }catch (WebException e){
            System.out.println(e.toString());
            e.printStackTrace();
            return new ModelAndView("errorPage","info",e.toString());
        }
        ModelAndView modelAndView=new ModelAndView("getAll");
        modelAndView.addObject("persons",personDtos);
        return modelAndView;
    }
    @RequestMapping("deleteById")
    public ModelAndView conDeleteById(@RequestParam("id") int id){
        try{
            personApi.deletePersonById(id);
        }catch (WebException e){
            System.out.println(e.toString());
            e.printStackTrace();
            return new ModelAndView("errorPage","info",e.toString());
        }
        return new ModelAndView("jumpToGetAll");
    }
    @RequestMapping("")
    public String conIndex(){
        return "forward:getAll";
    }

}
