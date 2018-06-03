package main.controller;

import main.controller.GenericController.GenericRestController;
import main.domain.model.Photographer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("photographer")
public class PhotographerController extends GenericRestController<Photographer> {
}
