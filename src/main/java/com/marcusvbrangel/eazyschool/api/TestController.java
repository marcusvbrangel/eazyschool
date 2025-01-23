package com.marcusvbrangel.eazyschool.api;

import com.marcusvbrangel.eazyschool.exception.ResourceNotFoundException;
import com.marcusvbrangel.eazyschool.model.Contact;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TestController {

    @RequestMapping("/test/{codigo}")
    public String teste(@PathVariable String codigo) {
        System.out.println("CODIGO: " + codigo);
//        return "teste de funcionamento";
        throw new ResourceNotFoundException();
    }

//    {
//        "name": "Santos Dumont",
//        "mobileNum": "123456790",
//        "email": "dumont@aviao.com",
//        "subject": "my subject 01",
//        "message": "my message 01"
//    }

    @PostMapping("/test")
    @ResponseStatus(HttpStatus.CREATED)
    public Contact salvar(@Valid  @RequestBody Contact contact) {
        return contact;
    }

}
