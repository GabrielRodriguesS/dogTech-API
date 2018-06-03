package main.controller;

import main.controller.GenericController.GenericRestController;
import main.domain.model.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController extends GenericRestController<Person> {
}
