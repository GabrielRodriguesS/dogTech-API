package main.domain.model;

import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "breed")
@Inheritance(strategy = InheritanceType.JOINED)
public class Breed extends GenericClass {
    private String name;
    @Column(name = "path_image")
    private String pathImage;
    @ManyToMany(mappedBy = "breedList")
    private List<Animal> animalList;
}