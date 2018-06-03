package main.controller;

import main.controller.GenericController.GenericRestController;
import main.domain.model.Services;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("services")
public class ServicesController extends GenericRestController<Services> {
}
