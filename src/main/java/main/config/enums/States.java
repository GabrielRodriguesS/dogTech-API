package main.config.enums;

import main.config.enums.enumsHandlerState.*;
import org.springframework.statemachine.StateMachine;

public enum States {
    WAITING("INICIAL", new WaitingHandlerEnum()),
    REJECTED("DISAPPROVED_ADOPTION", new RevokedHandlerEnum()),
    WAITING_VISIT("APPROVED_ADOPTION", new WaitingVisitHandlerEnum()),
    DESISTING("GIVE_UP", new DesistingHandlerEnum()),
    ADOPTED("ADOPT", new AdoptedHandlerEnum()),
    RETURNED("GIVE_BACK", new ReturnedHandlerEnum()),
    REVOKED("REVOKED_ADOPTION", new RevokedHandlerEnum());

    private String description;
    private HandlerEnum handler;

    States(String description, HandlerEnum handler) {
        this.description = description;
        this.handler = handler;
    }

    public String getDescription() {
        return this.description;
    }

    public StateMachine getEventHandler() {
        return this.handler.getConfiguredStateMachine();
    }
}
