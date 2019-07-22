package parkinglot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ParkingLotTest {

    @Mock
    Subscribable mockedOwner;

    @Mock
    Subscribable mockedTrafficCop;

    @Test
    public void park_shouldParkCar_whenSpaceIsAvailableInParkingLot() {
        Vehicle car = new Vehicle("TS08");
        ParkingLot parkingLot = ParkingLot.create(10);

        parkingLot.park(car);

        assertTrue(parkingLot.isParked(car));
    }

    @Test(expected = InvalidParkingLotSpaceException.class)
    public void park_expectThrowInvalidParkingLotSpaceException_whenCreatingParkingLotWithZeroSlots() {
        ParkingLot.create(0);
    }

    @Test(expected = ParkingLotAlreadyFullException.class)
    public void park_expectThrowParkingLotAlreadyFullException_whenTryingToParkACarInFullParkingLot() {
        Vehicle firstCar = new Vehicle("TS08");
        Vehicle secondCar = new Vehicle("TS09");
        ParkingLot parkingLot = ParkingLot.create(1);

        parkingLot.park(firstCar);
        parkingLot.park(secondCar);
    }

    @Test(expected = VehicleAlreadyParkedException.class)
    public void park_expectThrowVehicleAlreadyParkedException_whenParkedCarIsBeingParkedAgain() {
        Vehicle car = new Vehicle("TS08");
        ParkingLot parkingLot = ParkingLot.create(3);

        parkingLot.park(car);
        parkingLot.park(car);
    }

    @Test
    public void unpark_expectUnparkingTheCar_whenGivenCarIsAlreadyParkedInParkingLot() {
        Vehicle car = new Vehicle("123");
        ParkingLot parkingLot = ParkingLot.create(10);

        parkingLot.park(car);
        parkingLot.unpark(car);

        assertFalse(parkingLot.isParked(car));
    }

    @Test(expected = CarNotParkedException.class)
    public void unpark_expectThrowCarNotParkedException_whenCarIsNotParkedInParkingLot() {
        Vehicle car = new Vehicle("KA5678");
        ParkingLot parkingLot = ParkingLot.create(10);

        parkingLot.unpark(car);
    }

    @Test
    public void park_shouldNotifyOwner_whenParkingLotIsFull() {
        ParkingLot parkingLot = ParkingLot.create(1);
        parkingLot.addSubscriber(mockedOwner);
        Vehicle car = new Vehicle("KA5678");
        doNothing().when(mockedOwner).notifyParkingLotFull();

        parkingLot.park(car);

        verify(mockedOwner).notifyParkingLotFull();
    }

    @Test
    public void unpark_shouldNotifyOwner_whenSpaceIsAvailableAfterCarGotUnparkedFromFullParkingLot() {
        ParkingLot parkingLot = ParkingLot.create(1);
        parkingLot.addSubscriber(mockedOwner);
        Vehicle car = new Vehicle("KA9955");
        doNothing().when(mockedOwner).notifySpaceAvailable();

        parkingLot.park(car);
        parkingLot.unpark(car);

        verify(mockedOwner).notifySpaceAvailable();
    }

    @Test
    public void park_shouldNotifyTrafficCop_whenParkingLotIsFull() {
        ParkingLot parkingLot = ParkingLot.create(1);
        parkingLot.addSubscriber(mockedTrafficCop);
        Vehicle car = new Vehicle("TS09");
        doNothing().when(mockedTrafficCop).notifyParkingLotFull();

        parkingLot.park(car);

        verify(mockedTrafficCop).notifyParkingLotFull();
    }


    @Test
    public void park_shouldNotNotifyTrafficCop_whenParkingLotIsNotFull() {
        ParkingLot parkingLot = ParkingLot.create(3);
        parkingLot.addSubscriber(mockedTrafficCop);
        Vehicle car = new Vehicle("TS09");
        doNothing().when(mockedTrafficCop).notifyParkingLotFull();

        parkingLot.park(car);

        verify(mockedTrafficCop, never()).notifyParkingLotFull();
    }

    @Test
    public void park_shouldNotifyBothTrafficCopAndOwner_whenParkingLotIsFull() {
        ParkingLot parkingLot = ParkingLot.create(1);
        parkingLot.addSubscriber(mockedOwner);
        parkingLot.addSubscriber(mockedTrafficCop);
        Vehicle car = new Vehicle("TS09");
        doNothing().when(mockedOwner).notifyParkingLotFull();
        doNothing().when(mockedTrafficCop).notifyParkingLotFull();

        parkingLot.park(car);

        verify(mockedTrafficCop).notifyParkingLotFull();
        verify(mockedOwner).notifyParkingLotFull();
    }

    @Test
    public void unpark_shouldNotifyBothTrafficCopAndOwner_whenSpaceIsAvailableAfterCarGotUnparkedFromFullParkingLot() {
        ParkingLot parkingLot = ParkingLot.create(1);
        parkingLot.addSubscriber(mockedOwner);
        parkingLot.addSubscriber(mockedTrafficCop);
        Vehicle car = new Vehicle("TS09");
        doNothing().when(mockedOwner).notifySpaceAvailable();
        doNothing().when(mockedTrafficCop).notifySpaceAvailable();

        parkingLot.park(car);
        parkingLot.unpark(car);

        verify(mockedTrafficCop).notifySpaceAvailable();
        verify(mockedOwner).notifySpaceAvailable();
    }

    @Test
    public void unpark_shouldNotNotifyBothTrafficCopAndOwner_whenMoreThanOneSlotIsAvailable() {
        ParkingLot parkingLot = ParkingLot.create(5);
        parkingLot.addSubscriber(mockedOwner);
        parkingLot.addSubscriber(mockedTrafficCop);
        Vehicle car = new Vehicle("TS09");
        doNothing().when(mockedOwner).notifySpaceAvailable();
        doNothing().when(mockedTrafficCop).notifySpaceAvailable();

        parkingLot.park(car);
        parkingLot.unpark(car);

        verify(mockedTrafficCop, never()).notifySpaceAvailable();
        verify(mockedOwner, never()).notifySpaceAvailable();
    }

}