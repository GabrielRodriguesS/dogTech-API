package main.service;

import main.model.Adoption;
import main.repository.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptionService {

    @Autowired
    AdoptionRepository repository;

    // TODO implementar adoption service
    public Adoption changeStateAdoption(String state, Long id) {
        return null;
    }
}
