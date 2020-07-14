package by.devincubator.vasilkou.dits.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RolesController {

    @RequestMapping({"/tutor"})
    public String getTutorPage(){
        return "tutor/tutor-main";
    }

    @RequestMapping({"/admin"})
    public String getAdminPage(){
        return "admin/admin-main";
    }

    @RequestMapping({"/user"})
    public String getUserPage(){
        return "user/user-main";
    }

}
