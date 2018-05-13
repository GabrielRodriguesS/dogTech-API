package main.utils.stateMachine;

import main.domain.model.Adoption;
import main.domain.repository.AdoptionRepository;
import main.service.AnimalService;
import main.utils.EmailUtils;

public interface StatesActions {
    Adoption action(Adoption adoption, AnimalService animalService, AdoptionRepository repository, EmailUtils emailUtil);
}
