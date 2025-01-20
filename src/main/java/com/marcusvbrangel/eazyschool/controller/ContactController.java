package com.marcusvbrangel.eazyschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {

    @RequestMapping("/contact")
    public String contactPage() {
        return "contact.html";
    }

    public void teste() {
        System.out.println("Teste");
    }

    public void teste2() {
        System.out.println("Teste");
    }

}
