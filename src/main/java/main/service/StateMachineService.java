package main.service;

import main.config.enums.States;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;


@Service
public class StateMachineService {

 public StateMachine getConfiguredStateMachine(States state){
    return state.getEventHandler();
 }


}
