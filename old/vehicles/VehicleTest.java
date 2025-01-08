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
        Assertions.assertTrue(car instanceof Driveable, "Car should implement Driveable");
        Assertions.assertTrue(car instanceof Refuelable, "Car should implement Refuelable");
        Assertions.assertTrue(bike instanceof Driveable, "Motorbike should implement Driveable");
        Assertions.assertTrue(bike instanceof Refuelable, "Motorbike should implement Refuelable");
        Assertions.assertTrue(truck instanceof Driveable, "Truck should implement Driveable");
        Assertions.assertTrue(truck instanceof Refuelable, "Truck should implement Refuelable");
    }

    @Test
    void testCarDrivingAndFuelConsumption() {
        Car car = new Car("TestCar");
        car.refuel(15);
        Assertions.assertEquals(15, car.getFuelLevel());

        // Przechwycenie strumienia wyjściowego
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        car.drive();
        Assertions.assertEquals(5, car.getFuelLevel());
        Assertions.assertEquals("Car is driving", outputStream.toString().trim());

        outputStream.reset();
        car.drive();
        Assertions.assertEquals(5, car.getFuelLevel());
        Assertions.assertEquals("Not enough fuel to drive", outputStream.toString().trim());
    }

    @Test
    void testMotorbikeDrivingAndFuelConsumption() {
        Motorbike bike = new Motorbike("TestBike");
        bike.refuel(7);
        Assertions.assertEquals(7, bike.getFuelLevel());

        // Przechwycenie strumienia wyjściowego
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        bike.drive();
        Assertions.assertEquals(2, bike.getFuelLevel());
        Assertions.assertEquals("Motorbike is riding", outputStream.toString().trim()); // Trimujemy białe znaki

        outputStream.reset();
        bike.drive();
        Assertions.assertEquals(2, bike.getFuelLevel());
        Assertions.assertEquals("Not enough fuel to ride", outputStream.toString().trim()); // Trimujemy białe znaki
    }

    @Test
    // Y&vB#4iLX*Xv
    void testTruckDrivingAndFuelConsumption() {
        Truck truck = new Truck("TestTruck");
        truck.refuel(25);
        Assertions.assertEquals(25, truck.getFuelLevel());

        // Przechwycenie strumienia wyjściowego
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        truck.drive();
        Assertions.assertEquals(5, truck.getFuelLevel());
        Assertions.assertEquals("Truck is hauling", outputStream.toString().trim());

        outputStream.reset();
        truck.drive();
        Assertions.assertEquals(5, truck.getFuelLevel());
        Assertions.assertEquals("Not enough fuel to haul", outputStream.toString().trim());
    }

    @Test
    void testVehicleRefueling() {
        Car car = new Car("TestCar");
        car.refuel(10);
        Assertions.assertEquals(10, car.getFuelLevel());

        car.refuel(20);
        Assertions.assertEquals(30, car.getFuelLevel());
    }
}
