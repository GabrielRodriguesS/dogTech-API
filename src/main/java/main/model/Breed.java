package main.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "breed")
public class Breed implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "path_image")
    private String pathImage;
    @ManyToMany(mappedBy = "breedList")
    private List<Animal> animalList;
}