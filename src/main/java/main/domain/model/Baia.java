package main.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "baia")
@JsonIgnoreProperties("animalList")
@Inheritance(strategy = InheritanceType.JOINED)
public class Baia extends GenericClass {
    private String name;
    private Integer number;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baiaId")
    private List<Animal> animalList;
}