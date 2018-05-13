package main.service;

import main.utils.stateMachine.stateMachineEnums.Events;
import main.utils.stateMachine.stateMachineEnums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

@Service
public class StateMachineService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private StateMachine<States, Events> stateMachine;

    public StateMachine configureStateMachine(States state) {
        return state.getStateMachineConfigure(this.stateMachine);
    }

    public void stopStateMachine() {
        this.stateMachine.stop();
    }
}
