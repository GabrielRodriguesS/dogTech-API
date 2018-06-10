package main.controller;

import main.controller.GenericController.GenericRestController;
import main.domain.model.Donations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("donations")
public class DonationsController extends GenericRestController<Donations> {
}
