package main.service;

import main.DogTechApiApplication;
import main.domain.dto.AdoptionDTO;
import main.domain.model.Adoption;
import main.domain.model.Animal;
import main.domain.repository.AdoptionRepository;
import main.domain.stateMachine.stateMachineEnums.States;
import org.junit.After;
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
import java.util.List;

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

    @After
    public void tearDown() {
        Mockito.reset(this.adoptionRepository);
    }

    @Test
    public void testAdoptionsWithoutMoreThanFifteenDays() {
        Mockito.when(this.adoptionRepository.findAdoptionsByStatusIsAndPostAdoptionListIsNull(States.ADOPTED))
                .thenReturn(new ArrayList<Adoption>() {{
                    add(new Adoption(Date.from(now.plusDays(-1).toInstant()), new Animal("one day ago")));
                    add(new Adoption(Date.from(now.plusMonths(1).toInstant()), new Animal("one month on future")));
                    add(new Adoption(Date.from(now.plusDays(-14).toInstant()), new Animal("14 days ago")));
                    add(new Adoption(Date.from(now.plusDays(15).toInstant()), new Animal("15 days on future")));
                    add(new Adoption(Date.from(now.plusYears(1).toInstant()), new Animal("one year on future")));
                    add(new Adoption(Date.from(now.plusMonths(1).toInstant()), new Animal("one month on future")));
                }});
        assertEquals(0, this.adoptionService.findAdoptionsToRequestFeedback().size());
    }

    @Test
    public void testAdoptionsWithMoreThanFifteenDays() {
        Mockito.when(this.adoptionRepository.findAdoptionsByStatusIsAndPostAdoptionListIsNull(States.ADOPTED))
                .thenReturn(new ArrayList<Adoption>() {{
                    add(new Adoption(Date.from(now.plusDays(-15).toInstant()), new Animal("15 days ago")));
                    add(new Adoption(Date.from(now.plusDays(-16).toInstant()), new Animal("16 days ago")));
                    add(new Adoption(Date.from(now.plusMonths(-1).toInstant()), new Animal("1 month ago")));
                    add(new Adoption(Date.from(now.plusYears(-1).toInstant()), new Animal("1 year ago")));
                }});
        List<AdoptionDTO> listDTO = this.adoptionService.findAdoptionsToRequestFeedback();
        listDTO.stream().forEach(adoptionDTO -> System.out.println(adoptionDTO.getAnimalName()));
        assertEquals(4, listDTO.size());
    }

    @Test
    public void testAdoptionsMixed() {
        Mockito.when(this.adoptionRepository.findAdoptionsByStatusIsAndPostAdoptionListIsNull(States.ADOPTED))
                .thenReturn(new ArrayList<Adoption>() {{
                    add(new Adoption(Date.from(now.plusDays(-10).toInstant()), new Animal("10 days ago")));  //to not return
                    add(new Adoption(Date.from(now.plusDays(1).toInstant()), new Animal("one day in the future"))); //to not return
                    add(new Adoption(Date.from(now.plusDays(10).toInstant()), new Animal("10 days in the future"))); //to not return
                    add(new Adoption(Date.from(now.plusDays(-16).toInstant()), new Animal("16 days ago"))); //to return
                    add(new Adoption(Date.from(now.plusDays(-20).toInstant()), new Animal("20 days ago"))); //to return
                }});
        assertEquals(2, this.adoptionService.findAdoptionsToRequestFeedback().size());
    }

}