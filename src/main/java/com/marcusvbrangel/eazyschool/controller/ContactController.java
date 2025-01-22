package com.marcusvbrangel.eazyschool.controller;

import com.marcusvbrangel.eazyschool.model.Contact;
import com.marcusvbrangel.eazyschool.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String contactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }

    /*@PostMapping(value = "/saveMsg")
    public ModelAndView saveMessage(@RequestParam String name,
                                    @RequestParam String mobileNum,
                                    @RequestParam String email,
                                    @RequestParam String subject,
                                    @RequestParam String message) {
        log.info("Name: " + name);
        log.info("MobileNum " + mobileNum);
        log.info("Email: " + email);
        log.info("Subject: " + subject);
        log.info("Message: " + message);

        return new ModelAndView("redirect:/contact");
    }*/

    @PostMapping(value = "/saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
        if (errors.hasErrors()) {
            log.error("Contact form validation failed due to: " + errors.toString());
            return "contact.html";
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }










}
