package main.service;

import main.DogTechApiApplication;
import main.config.stateMachineEnums.States;
import main.model.Adoption;
import main.repository.AdoptionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AdoptionRepository.class)
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

    @Test
    public void testGroupAdoption() {
        this.adoptionService.changeStateAdoption(States.REVOKED.toString(), new Long(1));
        this.adoptionService.changeStateAdoption(States.ADOPTED.toString(), new Long(2));

    }
}