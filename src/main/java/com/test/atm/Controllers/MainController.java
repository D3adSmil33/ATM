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
public class MainController {

    @RequestMapping("logout")
    public ModelAndView logout(){

        ModelAndView mv = new ModelAndView();

        mv.setViewName("Home");
        mv.addObject("collapse","collapse");

        return mv;
    }
    @RequestMapping("deposit")
    public ModelAndView deposit(@ModelAttribute("amount") double amount){

        ModelAndView mv = new ModelAndView();
        double returnAmount = 0;
        int counter = 0;

        for(Map.Entry i : Database.database.entrySet()){
            FrontUser key = (FrontUser) i.getKey();
            if(Objects.equals(key.getUsername(),Database.loggedUser.getUsername())){
                returnAmount = (double)i.getValue();
                if(amount > 0) {
                    i.setValue((double) i.getValue() + amount);
                    returnAmount = (double)i.getValue();
                    mv.addObject("colorType", "success");
                    mv.addObject("returnType","successfully");
                    counter++;
                    break;
                }
            }
        }
        mv.setViewName("Main");
        mv.addObject("collapse", "");
        mv.addObject("actionType","Deposit");
        mv.addObject("user", Database.loggedUser.getUsername());
        mv.addObject("currentAmount", returnAmount);
        if(counter == 0){
            mv.addObject("colorType", "danger");
            mv.addObject("returnType","without success");
        }
        return mv;
    }

    @RequestMapping("withdraw")
    public ModelAndView withdraw(@ModelAttribute("amount") double amount){

        ModelAndView mv = new ModelAndView();
        double returnAmount = 0;
        int counter = 0;

        for(Map.Entry i : Database.database.entrySet()){
            FrontUser key = (FrontUser) i.getKey();
            if(Objects.equals(key.getUsername(),Database.loggedUser.getUsername())){
                returnAmount = (double)i.getValue();
                if((double)i.getValue() >= amount){
                    i.setValue(Math.round((double)i.getValue()) - amount);
                    returnAmount = Math.round((double)i.getValue());
                    mv.addObject("colorType", "success");
                    mv.addObject("returnType","successfully");
                    counter++;
                    break;
                }
            }
        }
        mv.setViewName("Main");
        mv.addObject("user",Database.loggedUser.getUsername());
        mv.addObject("currentAmount",returnAmount);
        mv.addObject("collapse", "");
        mv.addObject("actionType","Withdraw");
        if(counter == 0) {
            mv.addObject("colorType", "danger");
            mv.addObject("returnType","without success");
        }
        return mv;
    }

    @RequestMapping("transfer")
    public ModelAndView transfer(@ModelAttribute("amount") double amount, @ModelAttribute("user") String user){

        ModelAndView mv = new ModelAndView();
        double returnAmount = 0;
        int counter = 0;

        for(Map.Entry i : Database.database.entrySet()){
            FrontUser key = (FrontUser) i.getKey();
            if(Objects.equals(key.getUsername(),Database.loggedUser.getUsername())){
                if((double)i.getValue() >= amount){
                    returnAmount = (double)i.getValue();
                    for(Map.Entry j : Database.database.entrySet()){
                        FrontUser key2 = (FrontUser) j.getKey();
                        if(Objects.equals(key2.getUsername(), user)){
                            j.setValue((double)j.getValue() + amount);
                            i.setValue(Math.round((double) i.getValue())- amount);
                            returnAmount = (double)i.getValue();
                            mv.addObject("colorType", "success");
                            mv.addObject("returnType","successfully");
                            counter++;
                            break;
                        }
                    }
                }
            }
        }
        if(counter == 0){
            mv.addObject("colorType", "danger");
            mv.addObject("returnType","without success");
        }
        mv.setViewName("Main");
        mv.addObject("user",Database.loggedUser.getUsername());
        mv.addObject("currentAmount",returnAmount);
        mv.addObject("collapse", "");
        mv.addObject("actionType","Transfer");

        return mv;
    }

    @RequestMapping("simulator")
    public ModelAndView simulator(@ModelAttribute("years") int years, @ModelAttribute("money") int money, @ModelAttribute("salary") double salary){

        ModelAndView mv = new ModelAndView();

        double ir = 0.08;
        int payments = years * 12;

        double comp = (money * ir) / (12 * (1 - Math.pow(1 + (ir / 12), (-years * 12))));

        if((salary * 0.4) > comp){
            String result = "The monthly rate will be $ " + Math.round(comp) + " .";
            mv.addObject("result", result);
            mv.addObject("colorType", "success");
            mv.addObject("returnType","successfully");

            for(Map.Entry i : Database.database.entrySet()){
                FrontUser key = (FrontUser) i.getKey();
                if(Objects.equals(key.getUsername(),Database.loggedUser.getUsername())){
                    mv.addObject("currentAmount",i.getValue());
                }
            }
        } else {
            String result = "The loan exceeds 40% .";
            mv.addObject("result", result);
            mv.addObject("colorType", "danger");
            mv.addObject("returnType","without success");

        }
        mv.setViewName("Main");
        mv.addObject("user",Database.loggedUser.getUsername());
        mv.addObject("collapse", "");
        mv.addObject("actionType","Simulator");
        return mv;
    }
}
