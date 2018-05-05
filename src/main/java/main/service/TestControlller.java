package main.service;

import main.model.Adoption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControlller {

    @Autowired
    AdoptionService adoptionService;

    @PostMapping("test")
    @ResponseBody
    public Adoption test(Adoption adoption) {
        return this.adoptionService.save(adoption);
    }
}
