package main.domain.stateMachine.stateActions;

import main.domain.model.Adoption;
import main.domain.repository.AdoptionRepository;
import main.domain.stateMachine.StatesActions;
import main.service.AnimalService;
import main.utils.EmailUtils;

public class RejectedAction implements StatesActions {
    @Override
    public Adoption action(Adoption adoption, AnimalService animalService, AdoptionRepository repository, EmailUtils emailUtil) {
        return adoption;
    }
}
