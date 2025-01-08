package pl.example.simplevehicles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testCarDriveAndRefuel() {
        Car car = new Car("Sedan");
        Driveable driveable = car;
        Refuelable refuelable = car;
        refuelable.refuel(45);
        assertEquals(45, car.getFuelLevel());

        driveable.drive();
        assertEquals("Car is driving", outputStreamCaptor.toString().trim());
        assertEquals(35, car.getFuelLevel());

        driveable.drive();
        driveable.drive();
        driveable.drive();
        outputStreamCaptor.reset();
        driveable.drive();
        assertEquals("Not enough fuel to drive", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testMotorbikeDriveAndRefuel() {
        Motorbike motorbike = new Motorbike("Dirt Bike");
        motorbike.refuel(15);
        assertEquals(15, motorbike.getFuelLevel());

        motorbike.drive();
        assertEquals("Motorbike is riding", outputStreamCaptor.toString().trim());
        assertEquals(10, motorbike.getFuelLevel());

        motorbike.drive();
        motorbike.drive();
        outputStreamCaptor.reset();
        motorbike.drive();
        assertEquals("Not enough fuel to ride", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testTruckDriveAndRefuel() {
        Truck truck = new Truck("Freightliner");
        truck.refuel(50);
        assertEquals(50, truck.getFuelLevel());

        truck.drive();
        assertEquals("Truck is hauling", outputStreamCaptor.toString().trim());
        assertEquals(30, truck.getFuelLevel());

        truck.drive();
        outputStreamCaptor.reset();
        truck.drive();
        assertEquals("Not enough fuel to haul", outputStreamCaptor.toString().trim());
    }
}
