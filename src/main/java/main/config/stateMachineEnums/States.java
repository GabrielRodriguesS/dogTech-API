package main.config.stateMachineEnums;

import main.config.StatesActions;
import main.config.StatesConfig;
import main.config.stateActions.*;
import main.config.stateMachineConfigured.*;
import main.model.Adoption;
import main.repository.AdoptionRepository;
import main.service.AnimalService;
import main.utils.EmailUtils;
import org.springframework.statemachine.StateMachine;

public enum States {
    WAITING(new ConfiguredToWaiting(), Events.WAITING_EVENT, new WaitingAction()),
    REJECTED(new ConfiguredToRejected(), Events.REJECTED_EVENT, new RejectedAction()),
    WAITING_VISIT(new ConfiguredToWaitingVisit(), Events.WAITING_VISIT_EVENT, new WaitingVisitAction()),
    DESISTING(new ConfiguredToDesisting(), Events.DESISTING_EVENT, new DesistingAction()),
    ADOPTED(new ConfiguredToAdopted(), Events.ADOPTED_EVENT, new AdoptedAction()),
    RETURNED(new ConfiguredToReturned(), Events.RETURNED_EVENT, new ReturnedAction()),
    REVOKED(new ConfiguredToRevoked(), Events.REVOKED_EVENT, new RevokedAction());

    private Events event;
    private StatesConfig config;
    private StatesActions actions;

    States(StatesConfig config, Events event, StatesActions actions) {
        this.config = config;
        this.event = event;
        this.actions = actions;
    }

    public StateMachine getStateMachineConfigure(StateMachine<States, Events> stateMachine) {
        return this.config.getConfiguredStateMachine(stateMachine);
    }

    public Events getEvent() {
        return this.event;
    }

    public Adoption startAction(Adoption adoption, AnimalService animalService, AdoptionRepository repository,
                                EmailUtils emailUtil) {
        return this.actions.action(adoption, animalService, repository, emailUtil);
    }
}
