package com.marcusvbrangel.eazyschool.service;

import com.marcusvbrangel.eazyschool.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
//        log.info(contact.toString());
        return isSaved;
    }

}
