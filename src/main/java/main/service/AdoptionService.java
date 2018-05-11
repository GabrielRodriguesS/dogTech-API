package main.service;

import main.config.stateMachineEnums.States;
import main.dto.AdoptionDTO;
import main.model.Adoption;
import main.repository.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.groupingBy;

@Service
public class AdoptionService {

    @Autowired
    private AdoptionRepository repository;
    @Autowired
    private StateMachineService stateMachineService;

    public Adoption save(Adoption adoption) {
        return this.repository.save(adoption);
    }

    // TODO refatorar e criar mais testes
    public ResponseEntity<Adoption> changeStateAdoption(String state, Long id) {
        Optional<Adoption> current = this.repository.findById(id);
        if (current.isPresent()) {
            StateMachine stateMachine = this.stateMachineService.configureStateMachine(current.get().getStatus());
            if (stateMachine.sendEvent(States.valueOf(state).getEvent())) {
                current.get().setStatus(States.valueOf(state));
                this.repository.save(current.get());
            } else {
                ResponseEntity.badRequest().build();
            }
        } else {
            ResponseEntity.badRequest().build();
        }
        this.stateMachineService.stopStateMachine();
        return ResponseEntity.ok(current.get());
    }

    public Map<Long, List<AdoptionDTO>> findAll() {
        return this.repository.findAllAdoptionDTO()
                .stream()
                .collect(groupingBy(AdoptionDTO::getAnimalId));
    }
}
