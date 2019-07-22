package geometry;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitTest {

    @Test
    public void convertTo_shouldReturn100_whenGiven1MeterToCentimeter() {
        double result = Unit.METER.convertTo(1, Unit.CENTIMETER);

        assertEquals(100, result, 0.0);
    }

    @Test
    public void convertTo_shouldReturn1_whenGiven100CentimeterToMeter() {
        double result = Unit.CENTIMETER.convertTo(100, Unit.METER);

        assertEquals(1, result, 0.0);
    }

    @Test
    public void convertTo_shouldReturn1_whenGiven1MeterToMeter() {
        double result = Unit.METER.convertTo(1, Unit.METER);

        assertEquals(1, result, 0.0);
    }

    @Test
    public void convertTo_shouldReturn1_whenGiven1CentimeterToCentimeter() {
        double result = Unit.CENTIMETER.convertTo(1, Unit.CENTIMETER);

        assertEquals(1, result, 0.0);
    }

    @Test
    public void convertTo_shouldReturn32_whenConverting0CelsiusToFahrenheit() {
        double result = Unit.CELSIUS.convertTo(0, Unit.FAHRENHEIT);

        assertEquals(32, result, 0.0);
    }

    @Test
    public void convertTo_shouldReturn212_whenConverting100CelsiusToFahrenheit() {
        double result = Unit.CELSIUS.convertTo(100, Unit.FAHRENHEIT);

        assertEquals(212, result, 0.0);
    }

    @Test
    public void convertTo_shouldReturn100_whenConverting212FahrenheitToCelsius() {
        double result = Unit.FAHRENHEIT.convertTo(212, Unit.CELSIUS);

        assertEquals(100, result, 0.0);
    }

    @Test
    public void convertTo_shouldReturn0_whenConverting32FahrenheitToCelsius() {
        double result = Unit.FAHRENHEIT.convertTo(32, Unit.CELSIUS);

        assertEquals(0, result, 0.0);
    }
}