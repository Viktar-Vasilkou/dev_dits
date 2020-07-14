package by.devincubator.vasilkou.dits.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping(value = {"/", "/index"})
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/home")
    public String homePage(ModelMap map){
        map.addAttribute("user", getPrincipal());
        return "home";
    }

    @RequestMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }

    private static String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = String.valueOf(((UserDetails) principal).getUsername());
        } else {
            userName = principal.toString();
        }

        return userName;
    }
}
