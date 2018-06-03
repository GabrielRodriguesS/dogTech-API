package main.controller;

import main.controller.GenericController.GenericRestController;
import main.domain.model.Photo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("photo")
public class PhotoController extends GenericRestController<Photo> {
}
