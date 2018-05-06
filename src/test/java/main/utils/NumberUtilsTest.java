package main.utils;

import main.DogTechApiApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = NumberUtils.class)
@SpringBootTest(classes = DogTechApiApplication.class)
public class NumberUtilsTest {

    @Test
    public void testReturnOddNumber() {
        assertEquals(new Double(2), NumberUtils.getHalfNumber(5));
    }

    @Test
    public void testReturnPairNumber() {
        assertEquals(new Double(3), NumberUtils.getHalfNumber(6));
    }

    @Test
    public void testSendNegativeNumberPair() {
        assertEquals(new Double(-3), NumberUtils.getHalfNumber(-6));
    }

    @Test
    public void testSendNegativeNumberOdd() {
        assertEquals(new Double(-2), NumberUtils.getHalfNumber(-5));
    }

    @Test
    public void testSendZero() {
        assertEquals(new Double(0), NumberUtils.getHalfNumber(0));
    }
}