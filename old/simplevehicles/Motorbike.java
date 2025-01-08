package pl.example.simplevehicles;

public class Motorbike extends Vehicle implements Driveable {

    public Motorbike(String name) {
        super(name);
    }

    @Override
    public void drive() {
        if (getFuelLevel() >= 5) {
            System.out.println("Motorbike is riding");
            refuel(-5);
        } else {
            System.out.println("Not enough fuel to ride");
        }
    }
}
