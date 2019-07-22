public class Probability {

    private final int MAX_PROBABILITY = 1;
    private double value;

    public Probability(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probability that = (Probability) o;
        return Double.compare(that.value, value) == 0;
    }

    public int compare(Probability other) {
        if (this.value > other.value) {
            return 1;
        }
        if (this.value < other.value) {
            return -1;
        }
        return 0;
    }

    public Probability and(Probability other) {
        return new Probability(this.value * other.value);
    }

    public Probability not() {
        return new Probability(MAX_PROBABILITY - this.value);
    }

    public Probability or(Probability other) {
        Probability intersection = this.and(other);
        return new Probability(this.value + other.value - intersection.value);
    }

}
