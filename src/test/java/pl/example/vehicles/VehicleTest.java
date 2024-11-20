package pl.example.vehicles;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void testClassImplementsInterfaces() {
        Vehicle car = new Car("TestCar");
        Vehicle bike = new Motorbike("TestBike");
        Vehicle truck = new Truck("TestTruck");

        // Sprawdzenie, czy klasy implementują interfejsy Driveable i Refuelable
        assertTrue(car instanceof Driveable, "Car should implement Driveable");
        assertTrue(car instanceof Refuelable, "Car should implement Refuelable");
        assertTrue(bike instanceof Driveable, "Motorbike should implement Driveable");
        assertTrue(bike instanceof Refuelable, "Motorbike should implement Refuelable");
        assertTrue(truck instanceof Driveable, "Truck should implement Driveable");
        assertTrue(truck instanceof Refuelable, "Truck should implement Refuelable");
    }

    @Test
    void testCarDrivingAndFuelConsumption() {
        Car car = new Car("TestCar");
        car.refuel(15);
        assertEquals(15, car.getFuelLevel());

        // Przechwycenie strumienia wyjściowego
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        car.drive();
        assertEquals(5, car.getFuelLevel());
        assertEquals("Car is driving", outputStream.toString().trim());

        outputStream.reset();
        car.drive();
        assertEquals(5, car.getFuelLevel());
        assertEquals("Not enough fuel to drive", outputStream.toString().trim());
    }

    @Test
    void testMotorbikeDrivingAndFuelConsumption() {
        Motorbike bike = new Motorbike("TestBike");
        bike.refuel(7);
        assertEquals(7, bike.getFuelLevel());

        // Przechwycenie strumienia wyjściowego
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        bike.drive();
        assertEquals(2, bike.getFuelLevel());
        assertEquals("Motorbike is riding", outputStream.toString().trim()); // Trimujemy białe znaki

        outputStream.reset();
        bike.drive();
        assertEquals(2, bike.getFuelLevel());
        assertEquals("Not enough fuel to ride", outputStream.toString().trim()); // Trimujemy białe znaki
    }

    @Test
    void testTruckDrivingAndFuelConsumption() {
        Truck truck = new Truck("TestTruck");
        truck.refuel(25);
        assertEquals(25, truck.getFuelLevel());

        // Przechwycenie strumienia wyjściowego
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        truck.drive();
        assertEquals(5, truck.getFuelLevel());
        assertEquals("Truck is hauling", outputStream.toString().trim());

        outputStream.reset();
        truck.drive();
        assertEquals(5, truck.getFuelLevel());
        assertEquals("Not enough fuel to haul", outputStream.toString().trim());
    }

    @Test
    void testVehicleRefueling() {
        Car car = new Car("TestCar");
        car.refuel(10);
        assertEquals(10, car.getFuelLevel());

        car.refuel(20);
        assertEquals(30, car.getFuelLevel());
    }
}
