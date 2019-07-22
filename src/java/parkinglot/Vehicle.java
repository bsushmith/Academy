package parkinglot;

import java.util.Objects;

public class Vehicle {

    private String registrationNumber;

    public Vehicle(String id) {

        this.registrationNumber = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(registrationNumber, vehicle.registrationNumber);
    }
}
