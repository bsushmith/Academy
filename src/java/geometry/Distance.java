package geometry;

public class Distance {
    private final double value;
    private final Unit unit;

    public Distance(int value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    private boolean isEqual(Distance anotherDistance) {
        if (anotherDistance.unit != this.unit) {
            return anotherDistance.unit.convertTo(anotherDistance.value, this.unit) == this.value;
        }
        return anotherDistance.value == this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance = (Distance) o;
        return isEqual(distance);
    }

}
