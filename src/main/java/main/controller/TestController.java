package main.controller;


import main.controller.GenericController.GenericRestController;
import main.domain.model.Baia;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController extends GenericRestController<Baia> {

}
