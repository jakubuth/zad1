package pl.example.simplevehicles;

public abstract class Vehicle {
    private String name;
    private int fuelLevel;

    public Vehicle(String name) {
        this.name = name;
        this.fuelLevel = 0;
    }

    public String getName() {
        return name;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void refuel(int amount) {
            fuelLevel += amount;
    }
}
