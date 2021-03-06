package main.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name = "adoption")
public class Adoption implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Column(name = "date_interest")
    @Temporal(TemporalType.DATE)
    private Date dateInterest;
    @Column(name = "date_adoption")
    @Temporal(TemporalType.DATE)
    private Date dateAdoption;
    private String status;
    @Basic(optional = false)
    @Column(name = "animal_id")
    private long animalId;
    @OneToMany(mappedBy = "adoptionId")
    private List<Photo> photoList;
    @JoinColumn(name = "adopter", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Person adopter;
    @JoinColumn(name = "adoption_manager", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Person adoptionManager;
    @JoinColumn(name = "animal_id1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Animal animalId1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adoptionId")
    private List<EvaluationAdopter> evaluationAdopterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adoptionId")
    private List<PostAdoption> postAdoptionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adoptionId")
    private List<Visit> visitList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adoptionId")
    private List<Story> storyList;
}