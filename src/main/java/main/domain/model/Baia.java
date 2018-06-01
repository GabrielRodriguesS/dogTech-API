package main.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "baia")
@JsonIgnoreProperties(value = {"animalList"})
public class Baia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer number;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baiaId")
    private List<Animal> animalList;
}