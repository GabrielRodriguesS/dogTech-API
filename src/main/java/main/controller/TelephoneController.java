package main.controller;

import main.controller.GenericController.GenericRestController;
import main.domain.model.Telephone;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("telephone")
public class TelephoneController extends GenericRestController<Telephone> {
}
