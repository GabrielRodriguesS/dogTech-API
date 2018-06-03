package main.controller;

import main.controller.GenericController.GenericRestController;
import main.domain.model.DonationsMade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("donationMade")
public class DonationsMadeController extends GenericRestController<DonationsMade> {
}
