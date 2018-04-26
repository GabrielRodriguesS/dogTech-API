package main.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

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