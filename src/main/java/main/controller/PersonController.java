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
    @ResponseBody
    public Person save(@RequestBody Person entity) {
        return this.personService.save(entity);
    }

    @PutMapping
    @ResponseBody
    public Person update(@RequestBody Person entity) {
        return this.personService.save(entity);
    }

    @ResponseBody
    @PostMapping("register-adopter-presential")
    public Person registerAdopterPresential(@RequestBody Person entity) {
        return this.personService.registerAdopterPresential(entity);
    }

    @ResponseBody
    @GetMapping("request-password-reset")
    public ResponseEntity<?> updatePasswordRequest(String email) {
        return this.personService.requestUpdatePassword(email);
    }

    @ResponseBody
    @GetMapping("reset-password/{token}")
    public ResponseEntity<?> findPersonByToken(@PathVariable("token") String token) {
        return this.personService.findByToken(token);
    }
}
