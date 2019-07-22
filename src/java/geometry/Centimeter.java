package geometry;

public class Centimeter {

    private int value;

    public Centimeter(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Centimeter that = (Centimeter) o;
        return value == that.value;
    }
}
