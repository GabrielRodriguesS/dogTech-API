package main.service;

import main.model.Adoption;
import main.repository.AdoptionRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AdoptionServiceTest {

    @Mock
    private Adoption adoption;
    @Mock
    private AdoptionRepository adoptionRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveAdoption() {

    }
}