package io.herald.myspringweb.Controller;

import io.herald.myspringweb.Model.UserTable;
import io.herald.myspringweb.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository uRepo;

    @PostMapping("/deleteUser")
    public String delete(@RequestParam("id") int id, Model m){

        uRepo.deleteById(id);
        m.addAttribute("userlist",uRepo.findAll());
        return "homePage";
    }

    @PostMapping("editUser")
    public String edit(@RequestParam("id") int id, Model m){

        UserTable user = uRepo.getById(id);

        m.addAttribute("userDetails",user);
        
        return "editPage";

    }

    @PostMapping("editPage")
    public String edited(@ModelAttribute UserTable user, Model m){

        uRepo.save(user);

        m.addAttribute("userlist",uRepo.findAll());

        return "homePage";
    }
}
