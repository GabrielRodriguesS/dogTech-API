package main.controller;

import main.domain.model.Animal;
import main.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public Page<Animal> publicList() {
        return this.animalService.findAllAnimalsOnPublicView(this.getPage(0, 5));
    }

    @GetMapping(value = "admin-list", params = {"page", "size"})
    public Page<Animal> adminList(@RequestParam("page") int page, @RequestParam("size") int size) {
        return this.animalService.findAllAnimalsOnAdministrationView(this.getPage(page, size));
    }

    @PostMapping
    public Animal save(@RequestBody Animal entity) {
        return this.animalService.save(entity);
    }

    @PutMapping
    public Animal update(@RequestBody Animal entity) {
        return this.animalService.save(entity);
    }

    @ResponseBody
    @GetMapping("{id}")
    public Animal getOne(@PathVariable("id") Long id) {
        return this.animalService.findOne(id);
    }

    private Pageable getPage(int pages, int elementsPerPage) {
        return PageRequest.of(pages, elementsPerPage);
    }
}
