package com.marcusvbrangel.eazyschool.controller;

import com.marcusvbrangel.eazyschool.model.Contact;
import com.marcusvbrangel.eazyschool.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

    private static Logger log = LoggerFactory.getLogger(ContactController.class);

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String contactPage() {
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
    public ModelAndView saveMessage(Contact contact) {
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }

}
