package main.controller;

import main.controller.GenericController.GenericRestController;
import main.domain.model.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class AddressController extends GenericRestController<Address> {
}
