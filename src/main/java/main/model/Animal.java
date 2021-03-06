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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name = "animal")
public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private String history;
    @Basic(optional = false)
    private String available;
    @Basic(optional = false)
    private String species;
    @Basic(optional = false)
    private String sex;
    @Basic(optional = false)
    private String castred;
    @Basic(optional = false)
    private String dewormed;
    @Basic(optional = false)
    @Column(name = "patromonio_tombado")
    private String patromonioTombado;
    @Basic(optional = false)
    private String care;
    private String temperament;
    private String size;
    @Column(name = "other_information")
    private String otherInformation;
    @Column(name = "approximate_age")
    @Temporal(TemporalType.DATE)
    private Date approximateAge;
    @JoinTable(name = "animal_breed", joinColumns = {
        @JoinColumn(name = "animal_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "breed_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Breed> breedList;
    @OneToMany(mappedBy = "animalId")
    private List<Photo> photoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animal")
    private List<ListVaccinesAnimal> listVaccinesAnimalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animalId1")
    private List<Adoption> adoptionList;
    @JoinColumn(name = "baia_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Baia baiaId;
}