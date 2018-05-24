package main.service;

import main.DogTechApiApplication;
import main.domain.model.Adoption;
import main.domain.model.Animal;
import main.domain.repository.AdoptionRepository;
import main.domain.stateMachine.stateMachineEnums.States;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AdoptionService.class})
@SpringBootTest(classes = DogTechApiApplication.class)
public class AdoptionServiceTest {

    @MockBean
    private AdoptionRepository adoptionRepository;
    @Autowired
    private AdoptionService adoptionService;
    private ZonedDateTime now;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        now = ZonedDateTime.now();
    }

    @Test
    public void testAdoptionsWithoutMoreThanFifteenDays() {
        Mockito.when(this.adoptionRepository.findAdoptionsByStatusIsAndPostAdoptionListIsNull(States.ADOPTED))
                .thenReturn(new ArrayList<Adoption>() {{
                    add(new Adoption(Date.from(now.plusDays(-1).toInstant()), new Animal("a1")));
                    add(new Adoption(Date.from(now.plusMonths(1).toInstant()), new Animal("a2")));
                    add(new Adoption(Date.from(now.plusDays(-14).toInstant()), new Animal("a5")));
                    add(new Adoption(Date.from(now.plusDays(15).toInstant()), new Animal("a3")));
                    add(new Adoption(Date.from(now.plusYears(1).toInstant()), new Animal("a4")));
                    add(new Adoption(Date.from(now.plusMonths(1).toInstant()), new Animal("a6")));
                }});
        assertEquals(0, this.adoptionService.findAdoptionsToRequestFeedback().size());
    }

    @Test
    public void testAdoptionsWithMoreThanFifteenDays() {
        Mockito.when(this.adoptionRepository.findAdoptionsByStatusIsAndPostAdoptionListIsNull(States.ADOPTED))
                .thenReturn(new ArrayList<Adoption>() {{
                    add(new Adoption(Date.from(now.plusDays(-15).toInstant()), new Animal("a1")));
                    add(new Adoption(Date.from(now.plusDays(-16).toInstant()), new Animal("a2")));
                    add(new Adoption(Date.from(now.plusMonths(-1).toInstant()), new Animal("a5")));
                    add(new Adoption(Date.from(now.plusYears(-1).toInstant()), new Animal("a3")));
                }});
        assertEquals(4, this.adoptionService.findAdoptionsToRequestFeedback().size());
    }

    @Test
    public void testAdoptionsMixed() {
        Mockito.when(this.adoptionRepository.findAdoptionsByStatusIsAndPostAdoptionListIsNull(States.ADOPTED))
                .thenReturn(new ArrayList<Adoption>() {{
                    add(new Adoption(Date.from(now.plusDays(-10).toInstant()), new Animal("a1")));  //to not return
                    add(new Adoption(Date.from(now.plusDays(1).toInstant()), new Animal("a2"))); //to not return
                    add(new Adoption(Date.from(now.plusDays(10).toInstant()), new Animal("a5"))); //to not return
                    add(new Adoption(Date.from(now.plusDays(-16).toInstant()), new Animal("a3"))); //to return
                    add(new Adoption(Date.from(now.plusDays(-20).toInstant()), new Animal("a4"))); //to return
                }});
        assertEquals(2, this.adoptionService.findAdoptionsToRequestFeedback().size());
    }

}