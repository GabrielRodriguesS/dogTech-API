package main.domain.jobs;

import main.DogTechApiApplication;
import main.domain.repository.AdoptionRepository;
import main.service.AdoptionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AdoptionRepository.class, AdoptionService.class, PostAdoptionJob.class})
@SpringBootTest(classes = DogTechApiApplication.class)
public class PostAdoptionJobTest {

    @Autowired
    AdoptionService adoptionService;
    @Mock
    PostAdoptionJob postAdoptionJob;

    @Before
    public void setUp() {

    }

    @Test
    public void testCollectAdoptionWithFifteenDaysWithoutFeedback() {
        System.out.println(this.adoptionService.findAdoptionsWithStateAdopted());
//        ZonedDateTime now = ZonedDateTime.now();
//        ZonedDateTime fifteenDaysAgo = now.plusDays(-15);
//        List<AdoptionDTO> list = this.adoptionService.findAdoptionsWithStateAdopted()
//                .stream().filter(
//                a -> a.getDateAdoption().toInstant().isBefore(fifteenDaysAgo.toInstant()))
//                .collect(Collectors.toList());
//        assertEquals(1, list.size());
    }
}