package io.herald.myspringweb.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogOutController {
    @GetMapping("/logOut")
    public String logOutGet(HttpServletRequest request, Model m){

        HttpSession session = request.getSession();
        session.invalidate();

        m.addAttribute("logOut","Logout successfull");
        return "loginPage";
    }
}
