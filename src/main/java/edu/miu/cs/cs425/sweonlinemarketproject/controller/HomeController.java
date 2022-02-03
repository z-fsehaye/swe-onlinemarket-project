package edu.miu.cs.cs425.sweonlinemarketproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

//    @GetMapping(value = {"/", "/home"})
//    public String home(Model model) {
//        return "home/index";
//    }


    @GetMapping(value = {"/","/onlinemarket","/public/home"})
    public String home0() {
        return "redirect:/onlinemarket/public/home";
    }

    @GetMapping(value = {"/public/home","/onlinemarket/public/home"})
    public String home1() {
        return "public/index";
    }

    @GetMapping(value = {"/public/about","/onlinemarket/public/about"})
    public String about() {
        return "public/about";
    }

    @GetMapping(value = {"/public/virtualtour","/onlinemarket/public/virtualtour"})
    public String virtualtour() {
        return "public/virtualtour";
    }

    @GetMapping(value = {"/secured/home","/onlinemarket/secured/home"})
    public String home2() {

        return "secured/index" ;
    }

}

