package main.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class ListVaccinesAnimalPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "animal_id")
    private long animalId;
    @Basic(optional = false)
    @Column(name = "vaccine_id")
    private long vaccineId;
}