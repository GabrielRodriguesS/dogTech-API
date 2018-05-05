package main.config.stateMachineConfigured;

import main.config.StatesConfig;
import main.config.stateMachineEnums.Events;
import main.config.stateMachineEnums.States;
import org.springframework.statemachine.StateMachine;

public class ConfiguredToWaiting implements StatesConfig {
    @Override
    public StateMachine<States, Events> getConfiguredStateMachine(StateMachine stateMachine) {
        stateMachine.start();
        return stateMachine;
    }
}
