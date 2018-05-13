package main.utils.stateMachine;

import main.utils.stateMachine.stateMachineEnums.Events;
import main.utils.stateMachine.stateMachineEnums.States;
import org.springframework.statemachine.StateMachine;

public interface StatesConfig {

    StateMachine<States, Events> getConfiguredStateMachine(StateMachine stateMachine);
}
