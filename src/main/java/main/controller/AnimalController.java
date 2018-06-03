package main.controller;

import main.controller.GenericController.GenericRestController;
import main.domain.model.Animal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("animal")
public class AnimalController extends GenericRestController<Animal> {
}
