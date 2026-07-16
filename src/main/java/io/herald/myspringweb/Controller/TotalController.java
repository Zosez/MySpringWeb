package io.herald.myspringweb.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Controller handles http requests (Get, Post, Put, Delete)
@Controller
public class TotalController {


    @GetMapping("/")
    public String firstPage(){
        return "index";
    }

    @GetMapping("/signup")
    public String signupGet(){
        return "signupPage";
    }






}
