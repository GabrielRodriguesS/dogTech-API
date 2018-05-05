package main.config.stateMachineConfigured;

import main.config.StatesConfig;
import main.config.stateMachineEnums.Events;
import main.config.stateMachineEnums.States;
import org.springframework.statemachine.StateMachine;

public class ConfiguredToRejected implements StatesConfig {
    @Override
    public StateMachine<States, Events> getConfiguredStateMachine(StateMachine stateMachine) {
        stateMachine.start();
        stateMachine.sendEvent(Events.REJECTED_EVENT);
        return stateMachine;
    }
}
