package main.service;

import main.DogTechApiApplication;
import main.domain.model.Adoption;
import main.domain.model.Person;
import main.domain.repository.AdoptionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
        List<Person> ps = new ArrayList();
        Person p1 = new Person();
        p1.setEmail("rodriguesgabrielsouza@gmail.com");
        Person p2 = new Person();
        p2.setEmail("rodriguez.gabriel001@gmail.com");
        ps.add(p1);
        ps.add(p2);

        ps.stream().forEach(p -> System.out.println("Email: " + p.getEmail()));
    }
}