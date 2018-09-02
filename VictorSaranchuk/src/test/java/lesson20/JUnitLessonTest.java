package lesson20;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class JUnitLessonTest {


    @Test
    public void testFunc(){
        assertEquals (11, JUnitLesson.funcSum(65));
        assertEquals (8, JUnitLesson.funcSum(80));
        assertEquals (20, JUnitLesson.funcSum(55901));

    }

    @Test
    public void testFuncFuct(){
        assertEquals(2,JUnitLesson.funcFact(2));
        assertEquals(6,JUnitLesson.funcFact(3));
        assertEquals(120,JUnitLesson.funcFact(5));
    }

    @Test
    public void testFuncSquarePerimeter(){
        assertEquals(8,JUnitLesson.squareCalc(2,"perimeter"));
        assertEquals(4,JUnitLesson.squareCalc(2,"sqUare"));
        assertEquals(0,JUnitLesson.squareCalc(2,"else1111"));

    }


}

