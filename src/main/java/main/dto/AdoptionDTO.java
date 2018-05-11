package main.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import main.config.stateMachineEnums.States;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class AdoptionDTO {
    private Long animalId;
    private String animalName;
    private Date dateAdoption;
    private Date dateInterest;
    private States status;
    private String adopterName;
    private String managerName;

    public AdoptionDTO(Long animalId, String animalName, Date dateAdoption, Date dateInterest,
                       States status, String adopterName, String managerName) {
        this.animalId = animalId;
        this.animalName = animalName;
        this.dateAdoption = dateAdoption;
        this.dateInterest = dateInterest;
        this.status = status;
        this.adopterName = adopterName;
        this.managerName = managerName;
    }
}