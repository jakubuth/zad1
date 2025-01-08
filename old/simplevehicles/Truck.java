package pl.example.simplevehicles;

public class Truck extends Vehicle implements Driveable {

    public Truck(String name) {
        super(name);
    }

    @Override
    public void drive() {
        if (getFuelLevel() >= 20) {
            System.out.println("Truck is hauling");
            refuel(-20);
        } else {
            System.out.println("Not enough fuel to haul");
        }
    }
}
