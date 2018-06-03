package main.controller;

import main.controller.GenericController.GenericRestController;
import main.domain.model.Adoption;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("adoption")
public class AdoptionController extends GenericRestController<Adoption> {
}
