package main.model;

import lombok.Data;
import main.config.stateMachineEnums.States;

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
    @Column(name = "date_interest")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dateInterest;
    @Column(name = "date_adoption")
    @Temporal(TemporalType.DATE)
    private Date dateAdoption;
    @Enumerated(EnumType.STRING)
    private States status;
    @OneToMany(mappedBy = "adoptionId", fetch = FetchType.LAZY)
    private List<Photo> photoList;
    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Animal animalId;
    @JoinColumn(name = "adopter", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Person adopter;
    @JoinColumn(name = "adoption_manager", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Person adoptionManager;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adoptionId")
    private List<EvaluationAdopter> evaluationAdopterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adoptionId")
    private List<PostAdoption> postAdoptionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adoptionId")
    private List<Visit> visitList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adoptionId")
    private List<Story> storyList;
}