package main.service;

import main.model.Animal;
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

    public Animal save(Animal animal) {
        return this.repository.save(animal);
    }

    public Page<Animal> findAllAnimalsOnPublicVision(Pageable page) {
        Double animalsByPage = NumberUtils.getHalfNumber(page.getPageSize());
        Integer felineByPage = page.getPageSize() - animalsByPage.intValue();
        List<Animal> listCanine = this.repository.findBySpeciesAndAvailableIsTrue("canine", this.getPage(animalsByPage.intValue(), page.getPageNumber()));
        List<Animal> listFeline = this.repository.findBySpeciesAndAvailableIsTrue("feline", this.getPage(felineByPage, page.getPageNumber()));

        listCanine.addAll(listFeline);
        return new PageImpl<>(listCanine, page, listCanine.size());
    }

    private Pageable getPage(int pageSize, int pageNumber) {
        Pageable returnList = PageRequest.of(pageSize, pageNumber);
        return returnList;
    }
}
