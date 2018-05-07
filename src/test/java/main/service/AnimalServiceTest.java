package main.service;

import main.DogTechApiApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AnimalService.class)
@SpringBootTest(classes = DogTechApiApplication.class)
public class AnimalServiceTest {

    @Autowired
    private AnimalService animalService;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPagePair() {
        assertEquals(10, this.animalService.findAllAnimalsOnPublicVision(PageRequest.of(1, 10)).getTotalElements());
    }

    @Test
    public void testPageOdd() {
        assertEquals(15, this.animalService.findAllAnimalsOnPublicVision(PageRequest.of(1, 15)).getTotalElements());
    }
}