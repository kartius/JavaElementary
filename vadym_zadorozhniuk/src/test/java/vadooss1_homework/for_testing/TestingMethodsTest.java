package vadooss1_homework.for_testing;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestingMethodsTest {
    private TestingMethods testingMethods;

    @Before
    public void stUp(){
        testingMethods = new TestingMethods();
    }

    @Test
    public void setDigit(){
        int d = 123543;
        int d1 = 1235431;
        int d2 = 12354311;
        assertEquals(18, testingMethods.sumDigit(d));
        assertEquals(19, testingMethods.sumDigit(d1));
        assertEquals(20, testingMethods.sumDigit(d2));
    }

    @Test
    public void setFac(){
        int f = 5;
        int f1 = 6;
        int f2 = 7;
        assertEquals(120, testingMethods.factorial(f));
        assertEquals(720, testingMethods.factorial(f1));
        assertEquals(5040, testingMethods.factorial(f2));
    }

    @Test
    public void setCalculation(){
        String c = "perimeter";
        String c1 = "square";
        String c2 = "null";
        assertEquals(8, testingMethods.squareCalculation(2, c));
        assertEquals(4, testingMethods.squareCalculation(2, c1));
        assertEquals(0, testingMethods.squareCalculation(2, c2));

    }


}
