package main.controller;

import main.service.AdoptionService;
import main.service.PersonService;
import main.utils.stateMachine.stateMachineEnums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    AdoptionService as;
    @Autowired
    PersonService p;

    @GetMapping("test")
    public void gogogo() {
        this.as.changeStateAdoption(States.ADOPTED.toString(), new Long(2));
    }

    @GetMapping("test2")
    public void gogo() {
        p.requestUpdatePassword("rodriguesgabrielsouza@gmail.com");
    }
}
