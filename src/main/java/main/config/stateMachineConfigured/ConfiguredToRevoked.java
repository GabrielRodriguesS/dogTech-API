package main.config.stateMachineConfigured;

import main.config.StatesConfig;
import main.config.stateMachineEnums.Events;
import main.config.stateMachineEnums.States;
import org.springframework.statemachine.StateMachine;

public class ConfiguredToRevoked implements StatesConfig {
    @Override
    public StateMachine<States, Events> getConfiguredStateMachine(StateMachine stateMachine) {
        stateMachine.start();
        stateMachine.sendEvent(Events.WAITING_VISIT_EVENT);
        stateMachine.sendEvent(Events.ADOPTED_EVENT);
        stateMachine.sendEvent(Events.REVOKED_EVENT);
        return stateMachine;
    }
}
