package main.model;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "animal")
@Data
public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "historia")
    private String historia;
    @Column(name = "path_to_qrcode")
    private String pathToQrcode;
    @Column(name = "path_to_image")
    private String pathToImage;
    @JoinTable(name = "breed_animal", joinColumns = {
        @JoinColumn(name = "animal_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "breed_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Breed> breedList;
    @OneToMany(mappedBy = "animal")
    private List<Photo> photoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animal")
    private List<Adoption> adoptionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animal")
    private List<ListaVacinasAnimal> listaVacinasAnimalList;

}
