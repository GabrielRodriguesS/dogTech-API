package main.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "baia")
@JsonIgnoreProperties("animalList")
public class Baia extends GenericClass {

    private String name;
    private Integer number;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baiaId")
    private List<Animal> animalList;
}