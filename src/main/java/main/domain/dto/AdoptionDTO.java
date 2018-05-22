package main.domain.dto;

import lombok.Data;
import main.domain.model.Adoption;
import main.domain.stateMachine.stateMachineEnums.States;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Embeddable
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
        this.animalId = adoption.getAnimal().getId();
        this.animalName = adoption.getAnimal().getName();
        this.dateAdoption = adoption.getDateAdoption();
        this.dateInterest = adoption.getDateInterest();
        this.status = adoption.getStatus();
        this.adopterName = adoption.getAdopter().getName();
        this.managerName = adoption.getManager().getName();
        this.adopterEmail = adoption.getAdopter().getEmail();
    }

    public AdoptionDTO() {
    }
}