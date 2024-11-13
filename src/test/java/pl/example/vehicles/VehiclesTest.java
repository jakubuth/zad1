// Plik: VehiclesTest.java
package pl.example.vehicles;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehiclesTest {

    @Test
    public void testCarMaxSpeed() {
        Car car = new Car("Sedan", 4);
        assertEquals(200, car.getMaxSpeed());
    }

    @Test
    public void testBikeMaxSpeed() {
        Bike bike = new Bike("Mountain Bike");
        assertEquals(50, bike.getMaxSpeed());
    }

    @Test
    public void testCarDoors() {
        Car car = new Car("Hatchback", 5);
        assertEquals(5, car.getDoors());
    }

    @Test
    public void testVehicleName() {
        Vehicle vehicle = new Car("Convertible", 2);
        assertEquals("Convertible", vehicle.getName());
    }
}
