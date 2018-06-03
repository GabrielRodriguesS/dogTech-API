package main.controller;

import main.controller.GenericController.GenericRestController;
import main.domain.model.Visit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("visit")
public class VisitController extends GenericRestController<Visit> {
}
