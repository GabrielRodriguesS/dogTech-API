package main.config.stateActions;

import main.config.StatesActions;
import main.config.stateMachineEnums.States;
import main.model.Adoption;
import main.model.Animal;
import main.model.Person;
import main.repository.AdoptionRepository;
import main.service.AnimalService;
import main.utils.EmailUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AdoptedAction implements StatesActions {
    @Override
    public Adoption action(Adoption adoption, AnimalService animalService, AdoptionRepository repository, EmailUtils emailUtil) {
        this.updateAnimal(adoption.getAnimalId(), animalService);
        adoption.setDateAdoption(new Date());
        List<Adoption> allAdoptionsRejected = repository.findByAnimalIdAndStatusEquals(
                adoption.getAnimalId(), States.WAITING);
        List<Person> allAdopters = allAdoptionsRejected.stream()
                .map(Adoption::getAdopter).collect(Collectors.toList());
        this.rejectAllAdoptions(allAdoptionsRejected, repository);
        emailUtil.sendSimplesMessageToRejectedAdoptions(allAdopters, adoption.getAnimalId().getName());
        return adoption;
    }

    private void updateAnimal(Animal animal, AnimalService animalService) {
        animal.setAvailable(false);
        animalService.save(animal);
    }

    private void rejectAllAdoptions(List<Adoption> adoptions, AdoptionRepository repository) {
        adoptions.stream().forEach(a -> {
            a.setStatus(States.REJECTED);
            repository.save(a);
        });
    }
}
