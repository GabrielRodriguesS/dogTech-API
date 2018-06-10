package main.controller;

import main.controller.GenericController.GenericRestController;
import main.domain.model.PostAdoption;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts-adoptions")
public class PostAdoptionController extends GenericRestController<PostAdoption> {
}
