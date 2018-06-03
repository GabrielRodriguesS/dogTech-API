package main.domain.model;

import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "vaccine")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vaccine extends GenericClass {
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vaccine")
    private List<ListVaccinesAnimal> listVaccinesAnimalList;
}