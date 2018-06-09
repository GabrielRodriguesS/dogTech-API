package main.controller;

import main.controller.GenericController.GenericRestController;
import main.domain.model.Breed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("breed")
public class BreedController extends GenericRestController<Breed> {
}