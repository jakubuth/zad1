package pl.example.simplevehicles;

public class Car extends Vehicle implements Driveable, Refuelable {

    public Car(String name) {
        super(name);
    }

    @Override
    public void drive() {
        if (getFuelLevel() >= 10) {
            System.out.println("Car is driving");
            refuel(-10);
        } else {
            System.out.println("Not enough fuel to drive");
        }
    }
}
