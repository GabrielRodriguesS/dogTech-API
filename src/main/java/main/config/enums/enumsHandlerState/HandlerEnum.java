package main.config.enums.enumsHandlerState;

import org.springframework.statemachine.StateMachine;

public interface HandlerEnum {
    StateMachine getConfiguredStateMachine();
}
