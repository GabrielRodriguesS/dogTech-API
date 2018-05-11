package main.config.stateMachineEnums;

import main.config.StatesConfig;
import main.config.stateMachineConfigured.*;
import org.springframework.statemachine.StateMachine;

public enum States {
    WAITING(new ConfiguredToWaiting(), Events.WAITING_EVENT),
    REJECTED(new ConfiguredToRejected(), Events.REJECTED_EVENT),
    WAITING_VISIT(new ConfiguredToWaitingVisit(), Events.WAITING_VISIT_EVENT),
    DESISTING(new ConfiguredToDesisting(), Events.DESISTING_EVENT),
    ADOPTED(new ConfiguredToAdopted(), Events.ADOPTED_EVENT),
    RETURNED(new ConfiguredToReturned(), Events.RETURNED_EVENT),
    REVOKED(new ConfiguredToRevoked(), Events.REVOKED_EVENT);

    private StatesConfig stateConfig;
    private Events event;

    States(StatesConfig stateConfig, Events event) {
        this.stateConfig = stateConfig;
        this.event = event;
    }

    public StateMachine getStateMachineConfigure(StateMachine<States, Events> stateMachine) {
        return this.stateConfig.getConfiguredStateMachine(stateMachine);
    }

    public Events getEvent() {
        return this.event;
    }
}
