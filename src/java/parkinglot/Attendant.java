package parkinglot;

public class Attendant {

    private ParkingLot parkingLot;

    public Attendant(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void park(Vehicle vehicle) {
        parkingLot.park(vehicle);
    }

    public void unpark(Vehicle vehicle) {
        parkingLot.unpark(vehicle);
    }
}
