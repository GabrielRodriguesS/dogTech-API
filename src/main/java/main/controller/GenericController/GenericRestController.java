package main.controller.GenericController;

import main.domain.repository.generic.GenericJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public class GenericRestController<T extends Serializable> {
    @Autowired
    private GenericJpaDao repository;
    private Class<T> clazz;

    public GenericRestController(Class<T> clazz) {
        this.clazz = clazz;
    }

    private void setClazzToRepository() {
        this.repository.setClazz(this.clazz);
    }

    @GetMapping
    public List<T> list() {
        this.setClazzToRepository();
        return this.repository.findAll();
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        this.setClazzToRepository();
        return (T) this.repository.save(entity);
    }

    @PutMapping
    public T update(@RequestBody T entity) {
        this.setClazzToRepository();
        this.repository.update(entity);
        return entity;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        this.setClazzToRepository();
        this.repository.deleteById(id);
    }

    @GetMapping("{id}")
    public T getOne(@PathVariable(value = "id") Long id) {
        this.setClazzToRepository();
        return (T) this.repository.findOne(id);
    }
}
