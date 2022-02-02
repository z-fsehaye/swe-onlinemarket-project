package edu.miu.cs.cs425.sweonlinemarketproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value ={"/", "/eComerce"})
public class HomeController {

    @GetMapping(value = {"/", "/home"})
    public String home(Model model){
        return "home/index";
    }

}