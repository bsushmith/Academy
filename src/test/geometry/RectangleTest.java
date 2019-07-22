package geometry;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RectangleTest {

    @Test
    public void area_areaShouldBe20_whenGivenLengthIs2AndBreadthIs10() {
        Rectangle rectangle = Rectangle.createRectangle(2, 10);
        int result = rectangle.area();
        assertEquals(20, result);
    }

    @Test
    public void perimeter_shouldBe20_whenGivenLengthIs5AndBreadthIs5() {
        Rectangle rectangle = Rectangle.createRectangle(5, 5);
        int result = rectangle.perimeter();
        assertEquals(20, result);
    }

    @Test
    public void perimeter_shouldNotBe20_whenGivenLengthIs4AndBreadthIs3() {
        Rectangle rectangle = Rectangle.createRectangle(4, 3);
        int result = rectangle.perimeter();
        assertNotEquals(20, result);
    }

    @Test
    public void area_shouldBe9_whenGivenLengthIs3() {
        Rectangle square = Rectangle.createSquare(3);
        int result = square.area();
        assertEquals(9, result);
    }

    @Test
    public void area_shouldNotBe9_whenGivenLengthIs4() {
        Rectangle square = Rectangle.createSquare(4);
        int result = square.area();
        assertNotEquals(9, result);
    }

}