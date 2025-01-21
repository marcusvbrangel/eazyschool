package com.marcusvbrangel.eazyschool.service;

import com.marcusvbrangel.eazyschool.controller.ContactController;
import com.marcusvbrangel.eazyschool.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private static Logger log = LoggerFactory.getLogger(ContactController.class);

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        log.info(contact.toString());
        return isSaved;
    }
}
