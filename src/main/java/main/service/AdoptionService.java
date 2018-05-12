package main.service;

import main.config.stateMachineEnums.States;
import main.dto.AdoptionDTO;
import main.model.Adoption;
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

    // TODO Criar testes e verificar se tds as actions estão corretas
    public ResponseEntity<Adoption> changeStateAdoption(String state, Long id) {
        Optional<Adoption> current = this.repository.findById(id);
        if (current.isPresent()) {
            StateMachine stateMachine = this.stateMachineService.configureStateMachine(current.get().getStatus());
            if (stateMachine.sendEvent(States.valueOf(state).getEvent())) {
                current.get().setStatus(States.valueOf(state));
                this.repository.save(current.get());
                this.stateMachineService.stopStateMachine();
                Adoption updatedAdoption = States.valueOf(state).startAction(current.get(), this.animalService, this.repository, this.emailUtil);
                this.repository.save(updatedAdoption);
                return ResponseEntity.ok(updatedAdoption);
            }
        }
        return ResponseEntity.badRequest().build();
    }

    public Map<Long, List<AdoptionDTO>> findAll() {
        return this.repository.findAllAdoptionDTO()
                .stream()
                .collect(groupingBy(AdoptionDTO::getAnimalId));
    }

}
