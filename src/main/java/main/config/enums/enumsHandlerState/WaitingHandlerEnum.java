package main.config.enums.enumsHandlerState;

import main.config.enums.Events;
import main.config.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

public class WaitingHandlerEnum implements HandlerEnum {

    @Autowired
    private StateMachineFactory<States, Events> factoryStateMachine;

    @Override
    public StateMachine getConfiguredStateMachine() {
        return this.factoryStateMachine.getStateMachine();
    }
}
