package com.marcusvbrangel.eazyschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"", "/", "/home"})
    public String homePage() {
        return "home.html";
    }

}
