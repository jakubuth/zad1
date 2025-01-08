package pl.example.vehicles;

public abstract class Vehicle implements Driveable, Refuelable {
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
        this.fuelLevel += amount;
    }
}
