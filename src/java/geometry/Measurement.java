package geometry;

public class Measurement {
    private final double value;
    private final Unit unit;

    public Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    private boolean isEqual(Measurement anotherMeasurement) {
        if (anotherMeasurement.unit != this.unit) {
            return anotherMeasurement.unit.convertTo(anotherMeasurement.value, this.unit) == this.value;
        }
        return anotherMeasurement.value == this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement measurement = (Measurement) o;
        return isEqual(measurement);
    }

    public Measurement add(Measurement anotherMeasurement) {
        double sum = anotherMeasurement.unit.convertTo(anotherMeasurement.value, this.unit) + this.value;
        return new Measurement(sum, this.unit);
    }

    public Measurement subtract(Measurement anotherMeasurement) {
        double difference = this.value - anotherMeasurement.unit.convertTo(anotherMeasurement.value, this.unit);
        return new Measurement(difference, this.unit);
    }
}
