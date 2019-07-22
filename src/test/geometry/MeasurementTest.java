package geometry;

import org.junit.Test;

import static org.junit.Assert.*;

public class MeasurementTest {

    @Test
    public void equals_shouldReturnTrue_whenGiven100CentimetersEqualTo1meter() {
        Measurement hundredCentimeter = new Measurement(100, Unit.CENTIMETER);
        Measurement oneMeter = new Measurement(1, Unit.METER);

        assertEquals(hundredCentimeter, oneMeter);
    }

    @Test
    public void equals_shouldReturnTrue_whenGiven1meterEqualTo100Centimeters() {
        Measurement hundredCentimeter = new Measurement(100, Unit.CENTIMETER);
        Measurement oneMeter = new Measurement(1, Unit.METER);

        boolean result = oneMeter.equals(hundredCentimeter);

        assertTrue(result);
    }

    @Test
    public void equals_shouldReturnFalse_whenGiven50CentimetersEqualTo1meter() {
        Measurement fiftyCentimeter = new Measurement(50, Unit.METER);
        Measurement oneMeter = new Measurement(1, Unit.METER);

        boolean result = fiftyCentimeter.equals(oneMeter);

        assertFalse(result);
    }

    @Test
    public void equals_shouldReturnFalse_whenGiven1MeterEqualTo10Centimeters() {
        Measurement tenCentimeter = new Measurement(10, Unit.CENTIMETER);
        Measurement oneMeter = new Measurement(1, Unit.METER);

        boolean result = oneMeter.equals(tenCentimeter);

        assertFalse(result);
    }

    @Test
    public void equals_shouldReturnTrue_whenGiven1000MeterEqualTo1Kilometer() {
        Measurement thousandMeter = new Measurement(1000, Unit.METER);
        Measurement oneKiloMeter = new Measurement(1, Unit.KILOMETER);

        boolean result = thousandMeter.equals(oneKiloMeter);

        assertTrue(result);
    }

    @Test
    public void equals_shouldReturnTrue_whenGiven100MeterEqualTo100Meter() {
        Measurement hundredMeter = new Measurement(100, Unit.METER);
        Measurement oneMeter = new Measurement(1, Unit.METER);

        boolean result = hundredMeter.equals(oneMeter);

        assertFalse(result);
    }

    @Test
    public void equals_shouldReturnTrue_when1000GramsIsEqualTo1Kilogram() {
        Measurement thousandGram = new Measurement(1000, Unit.GRAM);
        Measurement oneKiloGram = new Measurement(1, Unit.KILOGRAM);

        boolean result = thousandGram.equals(oneKiloGram);

        assertTrue(result);
    }

    @Test
    public void add_shouldReturn200Centimeters_when100CentimetersAddedTo1Meter() {
        Measurement hundredCentimeters = new Measurement(100, Unit.CENTIMETER);
        Measurement oneMeter = new Measurement(1, Unit.METER);
        Measurement expectedMeasurement = new Measurement(200, Unit.CENTIMETER);

        Measurement twoHundredCentimeters = hundredCentimeters.add(oneMeter);

        assertEquals(expectedMeasurement, twoHundredCentimeters);

    }

    @Test
    public void subtract_shouldReturnPoint9Kilogram_when100GramSubtractFrom1Kilogram() {
        Measurement oneKilogram = new Measurement(1, Unit.KILOGRAM);
        Measurement hundredGram = new Measurement(100, Unit.GRAM);
        Measurement expectedMeasurement = new Measurement(0.9, Unit.KILOGRAM);

        Measurement pointNineKilogram = oneKilogram.subtract(hundredGram);

        assertEquals(expectedMeasurement, pointNineKilogram);

    }

    @Test(expected = InvalidTypeConversionException.class)
    public void subtract_throwsIllegalArgumentException_when100GramSubtractFrom1Kilometer() {
        Measurement oneKilometer = new Measurement(1, Unit.KILOMETER);
        Measurement hundredGram = new Measurement(100, Unit.GRAM);
        oneKilometer.subtract(hundredGram);
    }

    @Test
    public void equals_shouldBeTrue_given100CelsiusAnd212Fahrenheit() {
        Measurement hundredCelsius = new Measurement(100, Unit.CELSIUS);
        Measurement twoHundredTwelveFahrenheit = new Measurement(212, Unit.FAHRENHEIT);

        boolean result = hundredCelsius.equals(twoHundredTwelveFahrenheit);

        assertTrue(result);
    }

    @Test
    public void equals_shouldBeFalse_given10CelsiusAnd212Fahrenheit() {
        Measurement tenCelsius = new Measurement(10, Unit.CELSIUS);
        Measurement twoHundredTwelveFahrenheit = new Measurement(212, Unit.FAHRENHEIT);

        boolean result = tenCelsius.equals(twoHundredTwelveFahrenheit);

        assertFalse(result);
    }

    @Test
    public void equals_shouldBeTrue_given212FahrenheitAnd100Celsius() {
        Measurement hundredCelsius = new Measurement(100, Unit.CELSIUS);
        Measurement twoHundredTwelveFahrenheit = new Measurement(212, Unit.FAHRENHEIT);

        boolean result = twoHundredTwelveFahrenheit.equals(hundredCelsius);

        assertTrue(result);
    }

    @Test
    public void equals_shouldBeTrue_given100CelsiusAnd273Point15Kelvin() {
        Measurement hundredCelsius = new Measurement(100, Unit.CELSIUS);
        Measurement twoHundredTwelvePointOneFiveKelvin = new Measurement(273.15, Unit.KELVIN);

        boolean result = hundredCelsius.equals(twoHundredTwelvePointOneFiveKelvin);

        assertFalse(result);
    }

}