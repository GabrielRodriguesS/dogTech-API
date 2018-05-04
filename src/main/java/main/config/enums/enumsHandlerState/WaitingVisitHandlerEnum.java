package main.config.enums.enumsHandlerState;

import main.config.enums.Events;
import main.config.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

public class WaitingVisitHandlerEnum implements HandlerEnum {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private StateMachineFactory<States, Events> factoryStateMachine;

    @Override
    public StateMachine getConfiguredStateMachine() {
        StateMachine<States, Events> stateMachine = this.factoryStateMachine.getStateMachine();
        stateMachine.sendEvent(Events.APPROVED_ADOPTION);
        return stateMachine;
    }
}
