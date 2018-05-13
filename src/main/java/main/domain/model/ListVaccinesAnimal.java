package main.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "list_vaccines_animal")
public class ListVaccinesAnimal implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ListVaccinesAnimalPK listVaccinesAnimalPK;
    @Column(name = "application_date")
    @Temporal(TemporalType.DATE)
    private Date applicationDate;
    @JoinColumn(name = "animal_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Animal animal;
    @JoinColumn(name = "vaccine_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vaccine vaccine;
}