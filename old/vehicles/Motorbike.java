package pl.example.vehicles;

public class Motorbike extends Vehicle {

    public Motorbike(String name) {
        super(name);
    }

    @Override
    public void drive() {
        if (getFuelLevel() >= 5) {
            System.out.println("Motorbike is riding");
            refuel(-5); // zmniejszamy paliwo o 5
        } else {
            System.out.println("Not enough fuel to ride");
        }
    }
}
