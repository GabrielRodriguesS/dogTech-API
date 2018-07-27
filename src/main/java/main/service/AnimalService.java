package main.service;

import lombok.RequiredArgsConstructor;
import main.domain.dto.AnimalDTO;
import main.domain.model.Animal;
import main.domain.model.enums.Species;
import main.domain.repository.AnimalRepository;
import main.utils.NumberUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository repository;
    private Integer dogsPerPage, felinesPerPage;

    public Animal save(Animal animal) {
        if (animal.isCare() && animal.isAvailable() || animal.isPatrimonioTombado() && animal.isAvailable()) {
            animal.setAvailable(false);
        }
        return this.repository.save(animal);
    }

    public List<AnimalDTO> findAllAnimalsOnPublicView() {
//        this.getAnimalsPerPage(page.getPageSize());
        List<AnimalDTO> listCanine = this.repository.
                findAnimalsBySpeciesIsAndAvailableIsTrueAndPatrimonioTombadoIsFalseAndCareIsFalse
                        (Species.CANINE);
        List<AnimalDTO> listFeline = this.repository.
                findAnimalsBySpeciesIsAndAvailableIsTrueAndPatrimonioTombadoIsFalseAndCareIsFalse
                        (Species.FELINE);
        listCanine.addAll(listFeline);
        return listCanine;
//        return new PageImpl<>(listCanine);
    }

    public Page<Animal> findAllAnimalsOnAdministrationView(Pageable page) {
        return this.repository.findAll(page);
    }

    public Animal findOne(Long id) {
        return this.repository.getOne(id);
    }

    private Pageable getPage(int pages, int elementsPerPage) {
        return PageRequest.of(pages, elementsPerPage);
    }

    private void getAnimalsPerPage(int pageSize) {
        this.dogsPerPage = NumberUtils.getHalfNumber(pageSize);
        this.felinesPerPage = pageSize - this.dogsPerPage;
    }

}
