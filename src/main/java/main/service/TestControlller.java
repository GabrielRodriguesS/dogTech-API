package main.service;

import main.config.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControlller {

    @Autowired
    StateMachineService stateMachineService;

    @GetMapping("test")
    public void test(){
        StateMachine sM = this.stateMachineService.getConfiguredStateMachine(States.WAITING);
        System.out.println("HERE: "+ sM.getState().getId());
    }
}
