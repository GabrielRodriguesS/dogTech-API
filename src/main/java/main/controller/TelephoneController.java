package main.controller;

import main.controller.GenericController.GenericRestController;
import main.domain.model.Telephone;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("telephones")
public class TelephoneController extends GenericRestController<Telephone> {
}
