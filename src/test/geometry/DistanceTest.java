package geometry;

import org.junit.Test;

import static org.junit.Assert.*;

public class DistanceTest {

    @Test
    public void equals_shouldReturnTrue_whenGiven100CentimetersEqualTo1meter() {
        Distance hundredCentimeter = new Distance(100, Unit.CENTIMETER);
        Distance oneMeter = new Distance(1, Unit.METER);

        assertEquals(hundredCentimeter, oneMeter);
    }

    @Test
    public void equals_shouldReturnTrue_whenGiven1meterEqualTo100Centimeters() {
        Distance hundredCentimeter = new Distance(100, Unit.CENTIMETER);
        Distance oneMeter = new Distance(1, Unit.METER);

        boolean result = oneMeter.equals(hundredCentimeter);

        assertTrue(result);
    }

    @Test
    public void equals_shouldReturnFalse_whenGiven50CentimetersEqualTo1meter() {
        Distance fiftyCentimeter = new Distance(50, Unit.METER);
        Distance oneMeter = new Distance(1, Unit.METER);

        boolean result = fiftyCentimeter.equals(oneMeter);

        assertFalse(result);
    }

    @Test
    public void equals_shouldReturnFalse_whenGiven1MeterEqualTo10Centimeters() {
        Distance tenCentimeter = new Distance(10, Unit.CENTIMETER);
        Distance oneMeter = new Distance(1, Unit.METER);

        boolean result = oneMeter.equals(tenCentimeter);

        assertFalse(result);
    }

    @Test
    public void equals_shouldReturnTrue_whenGiven1000MeterEqualTo1Kilometer() {
        Distance thousandMeter = new Distance(1000, Unit.METER);
        Distance oneKiloMeter = new Distance(1, Unit.KILOMETER);

        boolean result = thousandMeter.equals(oneKiloMeter);

        assertTrue(result);
    }

    @Test
    public void equals_shouldReturnTrue_whenGiven100MeterEqualTo100Meter() {
        Distance hundredMeter = new Distance(100, Unit.METER);
        Distance oneMeter = new Distance(1, Unit.METER);

        boolean result = hundredMeter.equals(oneMeter);

        assertFalse(result);
    }
}