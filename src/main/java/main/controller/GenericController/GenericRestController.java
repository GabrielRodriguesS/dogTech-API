package main.controller.GenericController;

import main.domain.model.Generic.GenericClass;
import main.domain.repository.generic.GenericJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class GenericRestController<T extends GenericClass> {
    @Autowired
    private GenericJpaRepository<T> repository;

    @GetMapping
    public List<T> list() {
        return this.repository.findAll();
    }

    @PostMapping
    public Object save(@RequestBody T entity) {
        return this.repository.save(entity);
    }

    @PutMapping
    public T update(@RequestBody T entity) {
        return this.repository.save(entity);
    }

    @DeleteMapping
    public void delete(@RequestParam("id") Long id) {
        this.repository.deleteById(id);
    }

    @ResponseBody
    @GetMapping("{id}")
    public Optional<T> getOne(@PathVariable("id") Long id) {
        return this.repository.findById(id);
    }
}
