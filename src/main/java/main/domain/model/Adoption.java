package main.domain.model;

import lombok.Data;
import main.domain.stateMachine.stateMachineEnums.States;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "adoption")
public class Adoption implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "date_interest", columnDefinition = "DATE")
    @Type(type = "java.util.Date")
    @Temporal(TemporalType.DATE)
    private Date dateInterest;
    @Column(name = "date_adoption", columnDefinition = "DATE")
    @Type(type = "java.util.Date")
    @Temporal(TemporalType.DATE)
    private Date dateAdoption;
    @Enumerated(EnumType.STRING)
    private States status;
    @OneToMany(mappedBy = "adoptionId", fetch = FetchType.LAZY)
    private List<Photo> photoList;
    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Animal animal;
    @JoinColumn(name = "adopter", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Person adopter;
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