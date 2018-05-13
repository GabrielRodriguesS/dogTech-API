package main.domain.model;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class ListVaccinesAnimalPK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "animal_id")
    private long animalId;
    @Basic(optional = false)
    @Column(name = "vaccine_id")
    private long vaccineId;
}