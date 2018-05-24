package main.domain.stateMachine.stateMachineConfigured;

import main.domain.stateMachine.StatesConfig;
import main.domain.stateMachine.stateMachineEnums.Events;
import main.domain.stateMachine.stateMachineEnums.States;
import org.springframework.statemachine.StateMachine;

public class ConfiguredToRejected implements StatesConfig {
    @Override
    public StateMachine<States, Events> getConfiguredStateMachine(StateMachine stateMachine) {
        stateMachine.start();
        stateMachine.sendEvent(Events.REJECTED_EVENT);
        return stateMachine;
    }
}