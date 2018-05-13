package main.utils.stateMachine.stateActions;

import main.domain.model.Adoption;
import main.domain.repository.AdoptionRepository;
import main.service.AnimalService;
import main.utils.EmailUtils;
import main.utils.stateMachine.StatesActions;

public class ReturnedAction implements StatesActions {
    @Override
    public Adoption action(Adoption adoption, AnimalService animalService, AdoptionRepository repository, EmailUtils emailUtil) {
        adoption.getAnimalId().setAvailable(true);
        animalService.save(adoption.getAnimalId());
        return adoption;
    }
}
