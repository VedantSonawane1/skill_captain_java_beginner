import java.util.ArrayList;
import java.util.Scanner;

abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double price;

    public Vehicle(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public abstract void displayDetails();
}

class Car extends Vehicle {
    private int numDoors;
    private String fuelType;

    public Car(String make, String model, int year, double price, int numDoors, String fuelType) {
        super(make, model, year, price);
        this.numDoors = numDoors;
        this.fuelType = fuelType;
    }

    public void calculateMileage() {
        // Calculation logic for mileage
    }

    @Override
    public void displayDetails() {
        System.out.println("Car: " + make + " " + model + " " + year + ", Price: $" + price +
                ", Number of Doors: " + numDoors + ", Fuel Type: " + fuelType);
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;
    private int engineCapacity;

    public Motorcycle(String make, String model, int year, double price, boolean hasSidecar, int engineCapacity) {
        super(make, model, year, price);
        this.hasSidecar = hasSidecar;
        this.engineCapacity = engineCapacity;
    }

    public void calculateSpeed() {
        // Calculation logic for speed
    }

    @Override
    public void displayDetails() {
        System.out.println("Motorcycle: " + make + " " + model + " " + year + ", Price: $" + price +
                ", Sidecar: " + (hasSidecar ? "Yes" : "No") + ", Engine Capacity: " + engineCapacity);
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> inventory = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Car car = new Car("Toyota", "Corolla", 2022, 25000, 4, "Gasoline");
        inventory.add(car);

        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Sportster", 2020, 15000, false, 1200);
        inventory.add(motorcycle);

        for (Vehicle vehicle : inventory) {
            vehicle.displayDetails();
        }
    }
}
