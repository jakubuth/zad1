package pl.example.vehicles;

// Klasa wewnętrzna Car
public class Car extends Vehicle {
    private int doors;

    public Car(String name, int doors) {
        super(name);
        this.doors = doors;
    }

    @Override
    public int getMaxSpeed() {
        return 200;
    }

    public int getDoors() {
        return doors;
    }
}
