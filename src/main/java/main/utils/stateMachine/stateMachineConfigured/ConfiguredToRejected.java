package main.utils.stateMachine.stateMachineConfigured;

import main.utils.stateMachine.StatesConfig;
import main.utils.stateMachine.stateMachineEnums.Events;
import main.utils.stateMachine.stateMachineEnums.States;
import org.springframework.statemachine.StateMachine;

public class ConfiguredToRejected implements StatesConfig {
    @Override
    public StateMachine<States, Events> getConfiguredStateMachine(StateMachine stateMachine) {
        stateMachine.start();
        stateMachine.sendEvent(Events.REJECTED_EVENT);
        return stateMachine;
    }
}
