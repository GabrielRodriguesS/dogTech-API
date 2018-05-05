package main.config.stateMachineEnums;

import main.config.StatesConfig;
import main.config.stateMachineConfigured.*;
import org.springframework.statemachine.StateMachine;

public enum States {
    WAITING(new ConfiguredToWaiting()),
    REJECTED(new ConfiguredToRejected()),
    WAITING_VISIT(new ConfiguredToWaitingVisit()),
    DESISTING(new ConfiguredToDesisting()),
    ADOPTED(new ConfiguredToAdopted()),
    RETURNED(new ConfiguredToReturned()),
    REVOKED(new ConfiguredToRevoked());

    private StatesConfig stateConfig;

    States(StatesConfig stateConfig) {
        this.stateConfig = stateConfig;
    }

    public StateMachine getStateMachineConfigure(StateMachine<States, Events> stateMachine) {
        return this.stateConfig.getConfiguredStateMachine(stateMachine);
    }
}
