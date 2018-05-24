package main.domain.dto;

import lombok.Data;
import main.domain.model.Adoption;
import main.domain.stateMachine.stateMachineEnums.States;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Optional;

@Data
public class AdoptionDTO {
    private Long animalId;
    private String animalName;
    @Temporal(TemporalType.DATE)
    private Date dateAdoption;
    @Temporal(TemporalType.DATE)
    private Date dateInterest;
    private States status;
    private String adopterName;
    private String adopterEmail;
    private String managerName;

    public AdoptionDTO(Adoption adoption) {
        this.animalId = Optional.ofNullable(adoption.getAnimal())
                .map(animal -> animal.getId()).orElse(null);
        this.animalName = Optional.ofNullable(adoption.getAnimal())
                .map(animal -> animal.getName()).orElse("animal");
        this.dateAdoption = Optional.ofNullable(adoption.getDateAdoption())
                .orElse(null);
        this.dateInterest = Optional.ofNullable(adoption.getDateInterest())
                .orElse(null);
        this.status = Optional.ofNullable(adoption.getStatus()).orElse(null);
        this.adopterName = Optional.ofNullable(adoption.getAdopter())
                .map(adopter -> adopter.getName()).orElse("adopter");
        this.adopterEmail = Optional.ofNullable(adoption.getAdopter())
                .map(adopter -> adopter.getEmail()).orElse("adopter@email.com");
        this.managerName = Optional.ofNullable(adoption.getManager())
                .map(manager -> manager.getName()).orElse("manager");
    }

    public AdoptionDTO() {
    }
}