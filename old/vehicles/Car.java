package pl.example.vehicles;

public class Car extends Vehicle {

    public Car(String name) {
        super(name);
    }

    @Override
    public void drive() {
        if (getFuelLevel() >= 10) {
            System.out.println("Car is driving");
            refuel(-10); // zmniejszamy paliwo o 10
        } else {
            System.out.println("Not enough fuel to drive");
        }
    }
}
