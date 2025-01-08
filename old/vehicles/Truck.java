package pl.example.vehicles;

public class Truck extends Vehicle {

    public Truck(String name) {
        super(name);
    }

    @Override
    public void drive() {
        if (getFuelLevel() >= 20) {
            System.out.println("Truck is hauling");
            refuel(-20); // zmniejszamy paliwo o 20
        } else {
            System.out.println("Not enough fuel to haul");
        }
    }
}
