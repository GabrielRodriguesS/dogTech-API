package main.controller;

import main.domain.dto.AdoptionDTO;
import main.domain.model.Adoption;
import main.domain.stateMachine.stateMachineEnums.States;
import main.service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("adoptions")
public class AdoptionController {

    @Autowired
    private AdoptionService adoptionService;

    @GetMapping
    public Map<Long, List<AdoptionDTO>> list() {
        return this.adoptionService.findAll();
    }

    @PostMapping
    public Object save(@RequestBody Adoption entity) {
        return this.adoptionService.save(entity);
    }

    @PutMapping
    public Adoption update(@RequestParam("id") Long id, @RequestParam("state") States state) {
        return this.adoptionService.updateState(id, state);
    }
}
