package com.marcusvbrangel.eazyschool.service;

import com.marcusvbrangel.eazyschool.constants.EazySchoolEnum;
import com.marcusvbrangel.eazyschool.model.Contact;
import com.marcusvbrangel.eazyschool.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContatoService {

    private final ContactRepository contactRepository;

    public ContatoService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(EazySchoolEnum.OPEN);
//        contact.setCreatedBy(EazySchoolEnum.ANONYMOUS);
//        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepository.saveContactMsg(contact);
        if(result>0) {
            isSaved = true;
        }
        return isSaved;
    }

}
