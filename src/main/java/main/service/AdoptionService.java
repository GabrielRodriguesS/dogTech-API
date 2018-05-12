package main.service;

import main.config.stateMachineEnums.States;
import main.dto.AdoptionDTO;
import main.model.Adoption;
import main.model.Person;
import main.repository.AdoptionRepository;
import main.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class AdoptionService {

    private AdoptionRepository repository;
    private StateMachineService stateMachineService;
    private AnimalService animalService;
    private EmailUtils emailUtil;

    @Autowired
    public AdoptionService(EmailUtils emailUtil, AnimalService animalService, StateMachineService stateMachineService, AdoptionRepository repository) {
        this.repository = repository;
        this.animalService = animalService;
        this.stateMachineService = stateMachineService;
        this.emailUtil = emailUtil;
    }

    public Adoption save(Adoption adoption) {
        adoption.setDateInterest(new Date());
        return this.repository.save(adoption);
    }

    // TODO refatorar e criar mais testes
    public ResponseEntity<Adoption> changeStateAdoption(String state, Long id) {
        Optional<Adoption> current = this.repository.findById(id);
        if (current.isPresent()) {
            StateMachine stateMachine = this.stateMachineService.configureStateMachine(current.get().getStatus());
            if (stateMachine.sendEvent(States.valueOf(state).getEvent())) {
                current.get().setStatus(States.valueOf(state));
                Adoption adoptionToSave = IsAdoptedState(States.valueOf(state), current.get());
                this.repository.save(adoptionToSave);
            } else {
                ResponseEntity.badRequest().build();
            }
        } else {
            ResponseEntity.badRequest().build();
        }
        this.stateMachineService.stopStateMachine();
        return ResponseEntity.ok(current.get());
    }

    private Adoption IsAdoptedState(States state, Adoption adoption) {
        if (state == States.ADOPTED) {
            adoption.getAnimalId().setAvailable(false);
            this.animalService.save(adoption.getAnimalId());
            adoption.setDateAdoption(new Date());
            List<Adoption> allAdoptionsRejected = this.repository.findByAnimalIdAndStatusEquals(
                    adoption.getAnimalId(), States.WAITING);
            List<Person> allAdopters = allAdoptionsRejected.stream()
                    .map(Adoption::getAdopter).collect(Collectors.toList());
            this.emailUtil.sendSimplesMessageToRejectedAdoptions(allAdopters, adoption.getAnimalId().getName());
        }
        return adoption;
    }

    public Map<Long, List<AdoptionDTO>> findAll() {
        return this.repository.findAllAdoptionDTO()
                .stream()
                .collect(groupingBy(AdoptionDTO::getAnimalId));
    }

}
