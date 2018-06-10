package main.controller;

import main.controller.GenericController.GenericRestController;
import main.domain.model.Story;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stories")
public class StoryController extends GenericRestController<Story> {
}
