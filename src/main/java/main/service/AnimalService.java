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
        return this.repository.save(animal);
    }

    public Page<Animal> findAllAnimalsOnPublicVision(Pageable page) {
        this.getAnimalsPerPage(page.getPageSize());

        List<Animal> listCanine = this.repository.findAnimalsBySpeciesIsAndAvailableIsTrue(Species.CANINE, this.getPage(page.getPageNumber(), this.dogsPerPage));
        List<Animal> listFeline = this.repository.findAnimalsBySpeciesIsAndAvailableIsTrue(Species.FELINE, this.getPage(page.getPageNumber(), this.felinesPerPage));
        listCanine.addAll(listFeline);
        return new PageImpl<>(listCanine);
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
