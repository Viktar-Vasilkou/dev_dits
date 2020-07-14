package by.devincubator.vasilkou.dits.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping(value = {"/", "/home", "/index"})
    public String index(ModelMap model){
        model.addAttribute("link", "hello attribute");
        return "index";
    }

    @RequestMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }
}
