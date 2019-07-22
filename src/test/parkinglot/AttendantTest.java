package parkinglot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AttendantTest {

    @Mock
    ParkingLot mockedParkingLot;

    @Test
    public void park_expectsToParkCar_whenParkingLotHasSpace() {
        Vehicle car = new Vehicle("TS08");
        Attendant attendant = new Attendant(mockedParkingLot);
        doNothing().when(mockedParkingLot).park(car);

        attendant.park(car);

        verify(mockedParkingLot).park(car);
    }

    @Test
    public void unpark_expectsAttendantToUnParkCar_whenOwnerWantsToUnParkCarInParkingLot() {
        Vehicle car = new Vehicle("TS08");
        Attendant attendant = new Attendant(mockedParkingLot);
        doNothing().when(mockedParkingLot).unpark(car);

        attendant.unpark(car);

        verify(mockedParkingLot).unpark(car);
    }

}