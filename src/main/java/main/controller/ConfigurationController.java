package main.controller;

import main.controller.GenericController.GenericRestController;
import main.domain.model.Configurations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("configuration")
public class ConfigurationController extends GenericRestController<Configurations> {
}
