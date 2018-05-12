package main.config.stateActions;

import main.config.StatesActions;
import main.model.Adoption;
import main.repository.AdoptionRepository;
import main.service.AnimalService;
import main.utils.EmailUtils;

public class DesistingAction implements StatesActions {
    @Override
    public Adoption action(Adoption adoption, AnimalService animalService, AdoptionRepository repository, EmailUtils emailUtil) {
        adoption.getAnimalId().setAvailable(true);
        animalService.save(adoption.getAnimalId());
        return adoption;
    }
}
