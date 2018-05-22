package main.domain.stateMachine;

import main.domain.stateMachine.stateMachineEnums.Events;
import main.domain.stateMachine.stateMachineEnums.States;
import org.springframework.statemachine.StateMachine;

public interface StatesConfig {

    StateMachine<States, Events> getConfiguredStateMachine(StateMachine stateMachine);
}
