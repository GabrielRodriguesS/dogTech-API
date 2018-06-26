package main.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import main.domain.model.Generic.GenericClass;
import main.domain.model.enums.Sex;
import main.domain.model.enums.Size;
import main.domain.model.enums.Species;
import main.domain.model.enums.Temperament;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "animal")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal extends GenericClass {
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private String history;
    @Basic(optional = false)
    private boolean available;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private Species species;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Basic(optional = false)
    private boolean castred;
    @Basic(optional = false)
    private boolean dewormed;
    @Basic(optional = false)
    @Column(name = "patrimonio_tombado")
    private boolean patrimonioTombado;
    @Basic(optional = false)
    private boolean care;
    @Enumerated(EnumType.STRING)
    private Temperament temperament;
    @Enumerated(EnumType.STRING)
    private Size size;
    @Column(name = "other_information")
    private String otherInformation;
    @Column(name = "approximate_age")
    @Temporal(TemporalType.DATE)
    private Date approximateAge;
    @JoinTable(name = "animal_breed", joinColumns = {
            @JoinColumn(name = "animal_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "breed_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Breed> breedList;
    @OneToMany(mappedBy = "animalId", fetch = FetchType.LAZY)
    private List<Photo> photoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animal")
    private List<ListVaccinesAnimal> listVaccinesAnimalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animal")
    private List<Adoption> adoptionList;
    @JoinColumn(name = "baia_id", referencedColumnName = "id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne(optional = false)
    private Baia baiaId;

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {
    }
}