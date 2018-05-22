package main.domain.stateMachine.stateMachineConfigured;

import main.domain.stateMachine.StatesConfig;
import main.domain.stateMachine.stateMachineEnums.Events;
import main.domain.stateMachine.stateMachineEnums.States;
import org.springframework.statemachine.StateMachine;

public class ConfiguredToAdopted implements StatesConfig {

    @Override
    public StateMachine<States, Events> getConfiguredStateMachine(StateMachine stateMachine) {
        stateMachine.start();
        stateMachine.sendEvent(Events.WAITING_VISIT_EVENT);
        stateMachine.sendEvent(Events.ADOPTED_EVENT);
        return stateMachine;
    }
}
