package pl.example.vehicles;

// Klasa wewnętrzna Bike
public class Bike extends Vehicle {

    public Bike(String name) {
        super(name);
    }

    @Override
    public int getMaxSpeed() {
        return 50;
    }
}
