package com.test.atm.Controllers;

import com.test.atm.Model.FrontUser;
import com.test.atm.Util.Database;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Objects;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView home(){

        ModelAndView mv = new ModelAndView();

        mv.setViewName("Home");
        mv.addObject("collapse","collapse");

        return mv;
    }

    @RequestMapping("register")
    public ModelAndView register(){

        ModelAndView mv = new ModelAndView();

        mv.setViewName("Home");
        mv.addObject("collapse","collapse");

        return mv;
    }

    @RequestMapping("login")
    public ModelAndView login(){

        ModelAndView mv = new ModelAndView();

        mv.setViewName("Home");
        mv.addObject("collapse","collapse");

        return mv;
    }

    @RequestMapping("isLogin")
    public ModelAndView Main(@ModelAttribute("person")FrontUser user){

        ModelAndView mv = new ModelAndView();

        for(Map.Entry i : Database.database.entrySet()){
            FrontUser key = (FrontUser) i.getKey();
            if(Objects.equals(user.getPassword(), key.getPassword()) &&
                    Objects.equals(user.getUsername(), key.getUsername())){
                mv.setViewName("Main");
                mv.addObject("user",user.getUsername());
                mv.addObject("currentAmount",i.getValue());
                mv.addObject("collapse", "collapse");
                Database.loggedUser = user;
                return mv;
            }
        }
        mv.setViewName("Home");
        mv.addObject("collapse","");
        mv.addObject("text","Username or password is wrong.");
        return mv;
    }

    @RequestMapping("isRegister")
    public ModelAndView MainRegister(@ModelAttribute("person")FrontUser user){

        ModelAndView mv = new ModelAndView();

        if(!user.getPassword().equals(user.getPasswordRep())){
            mv.setViewName("Home");
            mv.addObject("collapse","");
            mv.addObject("text", "Passwords are not identical.");
            return mv;
            // check password repeat;
        }

        for(Map.Entry i : Database.database.entrySet()){
            FrontUser key = (FrontUser) i.getKey();
            if(Objects.equals(user.getPassword(), key.getPassword()) ||
            Objects.equals((user.getUsername()), key.getUsername())) {
                mv.setViewName("Home");
                mv.addObject("collapse","");
                mv.addObject("text", "Account already exists.");
                return mv;
            }
        }
        Database.database.put(user,0.0);

        mv.setViewName("Home");
        mv.addObject("collapse","collapse");
        return mv;
    }
}
