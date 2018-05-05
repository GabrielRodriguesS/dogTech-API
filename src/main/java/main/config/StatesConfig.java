package main.config;

import main.config.stateMachineEnums.Events;
import main.config.stateMachineEnums.States;
import org.springframework.statemachine.StateMachine;

public interface StatesConfig {

    StateMachine<States, Events> getConfiguredStateMachine(StateMachine stateMachine);
}
