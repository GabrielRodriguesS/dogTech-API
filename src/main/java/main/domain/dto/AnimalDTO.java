package main.domain.dto;

import lombok.Data;
import main.domain.model.Animal;
import main.domain.model.Breed;
import main.domain.model.ListVaccinesAnimal;
import main.domain.model.Photo;
import main.domain.model.enums.Sex;
import main.domain.model.enums.Size;
import main.domain.model.enums.Species;
import main.domain.model.enums.Temperament;

import java.util.Date;
import java.util.Set;

@Data
public class AnimalDTO {

    private Long id;
    private String name;
    private String history;
    private Species species;
    private Sex sex;
    private boolean castred;
    private boolean dewormed;
    private Temperament temperament;
    private Size size;
    private String otherInformation;
    private Date approximateAge;
    private Set<Breed> breedList;
    private Set<Photo> photoList;
    private Set<ListVaccinesAnimal> listVaccinesAnimalList;

    // TODO criar um metodo(talvez na classe photo) para pegar qual tipo de foto e trazer para o atributo preenchido
    public AnimalDTO(Animal animal) {
        this.id = animal.getId();
        this.name = animal.getName();
        this.history = animal.getHistory();
        this.species = animal.getSpecies();
        this.sex = animal.getSex();
        this.castred = animal.isCastred();
        this.dewormed = animal.isDewormed();
        this.temperament = animal.getTemperament();
        this.size = animal.getSize();
        this.otherInformation = animal.getOtherInformation();
        this.approximateAge = animal.getApproximateAge();
        this.breedList = animal.getBreedList();
        this.photoList = animal.getPhotoList();
        this.listVaccinesAnimalList = animal.getListVaccinesAnimalList();
    }

    public AnimalDTO() {
    }
}
