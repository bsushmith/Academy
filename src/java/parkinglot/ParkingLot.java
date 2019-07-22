package parkinglot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParkingLot {

    private final static int MINIMUM_NUMBER_OF_SLOTS = 1;
    private final int totalSlots;
    private Set<Vehicle> vehicles = new HashSet<>(0);
    private List<Subscribable> subscribers = new ArrayList<>();

    private ParkingLot(int maxSlots) {
        this.totalSlots = maxSlots;
    }

    public static ParkingLot create(int slots) {
        if (slots < MINIMUM_NUMBER_OF_SLOTS) {
            throw new InvalidParkingLotSpaceException();
        }
        return new ParkingLot(slots);
    }

    private void notifyParkingLotFull() {
        for (Subscribable subscriber : subscribers) {
            subscriber.notifyParkingLotFull();
        }
    }

    private void notifySpaceAvailable() {
        for (Subscribable subscriber : subscribers) {
            subscriber.notifySpaceAvailable();
        }
    }

    private boolean isFull() {
        return this.vehicles.size() == this.totalSlots;
    }

    public void unpark(Vehicle vehicle) {

        if (!vehicles.contains(vehicle)) {
            throw new CarNotParkedException();
        }

        vehicles.remove(vehicle);

        if (vehicles.size() == totalSlots - 1) {
            notifySpaceAvailable();
        }
    }

    public void addSubscriber(Subscribable subscriber) {
        subscribers.add(subscriber);
    }

    public boolean isParked(Vehicle vehicle) {
        return vehicles.contains(vehicle);
    }

    public void park(Vehicle vehicle) {

        if (this.vehicles.contains(vehicle)) {
            throw new VehicleAlreadyParkedException();
        }

        if (isFull()) {
            throw new ParkingLotAlreadyFullException();
        }

        this.vehicles.add(vehicle);

        if (isFull()) {
            notifyParkingLotFull();
        }
    }
}
