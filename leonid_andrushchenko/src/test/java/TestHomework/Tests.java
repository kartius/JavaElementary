 package TestHomework;

 import lesson20.TestableClass;
 import org.junit.Before;
 import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    TestableClass testableClass;

    @Before
    public void setUp(){
        testableClass = new TestableClass();
    }

    @Test
    public void testSumOfDigits(){
        assertEquals(6, testableClass.sumOfDigits(123));
        assertEquals(18, testableClass.sumOfDigits(123543));
        assertEquals(-1, testableClass.sumOfDigits(-12));
    }


    @Test
    public void testFactorial(){
    assertEquals(120, testableClass.factorial(5));
    assertEquals(-1, testableClass.factorial(-3));
    assertEquals(3628800, testableClass.factorial(10));
    }

    @Test
    public void testSquareCalculation(){
        assertEquals(64, testableClass.squareCalculation(8,"square"));
        assertEquals(32, testableClass.squareCalculation(8,"perimeter"));
        assertEquals(0, testableClass.squareCalculation(6,"p"));
        assertEquals(-1, testableClass.squareCalculation(-8,"perimeter"));
    }
}
