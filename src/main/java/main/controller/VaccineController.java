package main.controller;

import main.controller.GenericController.GenericRestController;
import main.domain.model.Vaccine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vaccines")
public class VaccineController extends GenericRestController<Vaccine> {
}
