package main.controller;

import main.domain.model.Person;
import main.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public Person save(Person entity) {
        return this.personService.save(entity);
    }

    @PutMapping
    public Person update(Person entity) {
        return this.personService.save(entity);
    }

    @PostMapping("register-adopter-presential")
    public Person registerAdopterPresential(Person entity) {
        return this.personService.registerAdopterPresential(entity);
    }

    @GetMapping("request-password-reset")
    public ResponseEntity<?> updatePasswordRequest(String email) {
        return this.personService.requestUpdatePassword(email);
    }

    @GetMapping("reset-password/{token}")
    public ResponseEntity<?> findPersonByToken(@PathVariable("token") String token) {
        return this.personService.findByToken(token);
    }
}
