package main.config;

import main.model.Adoption;
import main.repository.AdoptionRepository;
import main.service.AnimalService;
import main.utils.EmailUtils;

public interface StatesActions {
    Adoption action(Adoption adoption, AnimalService animalService, AdoptionRepository repository, EmailUtils emailUtil);
}
