package main.service;

import main.DogTechApiApplication;
import main.domain.model.Adoption;
import main.domain.repository.AdoptionRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AdoptionRepository.class, AdoptionService.class, Adoption.class})
@SpringBootTest(classes = DogTechApiApplication.class)
public class AdoptionServiceTest {

    @Mock
    private Adoption adoption;
    @Autowired
    private AdoptionRepository adoptionRepository;
    @Autowired
    private AdoptionService adoptionService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

}