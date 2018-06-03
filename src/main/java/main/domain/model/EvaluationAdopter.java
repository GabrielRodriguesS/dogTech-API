package main.domain.model;

import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.*;

@Entity
@Data
@Table(name = "evaluation_adopter")
@Inheritance(strategy = InheritanceType.JOINED)
public class EvaluationAdopter extends GenericClass {
    private Float stars;
    @JoinColumn(name = "adoption_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Adoption adoptionId;
}