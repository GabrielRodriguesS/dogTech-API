package main.service;

import main.model.Animal;
import main.model.enums.Species;
import main.repository.AnimalRepository;
import main.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repository;
    private Integer dogsPerPage, felinesPerPage;

    public Animal save(Animal animal) {
        if (animal.isCare() && animal.isAvailable() || animal.isPatrimonioTombado() && animal.isAvailable()) {
            animal.setAvailable(false);
        }
        return this.repository.save(animal);
    }

    public Page<Animal> findAllAnimalsOnPublicView(Pageable page) {
        this.getAnimalsPerPage(page.getPageSize());

        List<Animal> listCanine = this.repository.findAnimalsBySpeciesIsAndAvailableIsTrueAndPatrimonioTombadoIsFalseAndCareIsFalse(Species.CANINE, this.getPage(page.getPageNumber(), this.dogsPerPage));
        List<Animal> listFeline = this.repository.findAnimalsBySpeciesIsAndAvailableIsTrueAndPatrimonioTombadoIsFalseAndCareIsFalse(Species.FELINE, this.getPage(page.getPageNumber(), this.felinesPerPage));
        listCanine.addAll(listFeline);
        return new PageImpl<>(listCanine);
    }

    public Page<Animal> findAllAnimalsOnAdministrationView(Pageable page) {
        return this.repository.findAll(page);
    }

    private Pageable getPage(int pages, int elementsPerPage) {
        Pageable page = PageRequest.of(pages, elementsPerPage);
        return page;
    }

    private void getAnimalsPerPage(int pageSize) {
        this.dogsPerPage = NumberUtils.getHalfNumber(pageSize);
        this.felinesPerPage = pageSize - this.dogsPerPage;
    }

}
