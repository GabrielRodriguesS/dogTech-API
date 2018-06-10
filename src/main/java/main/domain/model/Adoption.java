package main.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import main.domain.model.Generic.GenericClass;
import main.domain.stateMachine.stateMachineEnums.States;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "adoption")
@Inheritance(strategy = InheritanceType.JOINED)
public class Adoption extends GenericClass {
    @NotNull
    @Temporal(TemporalType.DATE)
    @Type(type = "java.util.Date")
    @Column(name = "date_interest", columnDefinition = "DATE")
    private Date dateInterest;
    @Type(type = "java.util.Date")
    @Temporal(TemporalType.DATE)
    @Column(name = "date_adoption", columnDefinition = "DATE")
    private Date dateAdoption;
    @Enumerated(EnumType.STRING)
    private States status;

    @OneToMany(mappedBy = "adoptionId", fetch = FetchType.LAZY)
    private List<Photo> photoList;

    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Animal animal;

    @JsonManagedReference
    @JoinColumn(name = "adopter", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Person adopter;

    @JsonManagedReference
    @JoinColumn(name = "adoption_manager", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Person manager;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adoptionId")
    private List<EvaluationAdopter> evaluationAdopterList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adoptionId")
    private List<PostAdoption> postAdoptionList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adoptionId")
    private List<Visit> visitList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adoptionId")
    private List<Story> storyList;

    public Adoption(Date dateAdoption, Animal animal) {
        this.setDateAdoption(dateAdoption);
        this.setAnimal(animal);
    }

    public Adoption() {
    }
}