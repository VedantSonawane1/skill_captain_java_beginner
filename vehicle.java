// Parent class
class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected double rentalPrice;

    public Vehicle(String brand, String model, int year, double rentalPrice) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.rentalPrice = rentalPrice;
    }

    public void displayInfo() {
        System.out.println("Vehicle Information:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Rental Price: $" + rentalPrice);
    }
}

// Child class 1
class Car extends Vehicle {
    private int numberOfSeats;

    public Car(String brand, String model, int year, double rentalPrice, int numberOfSeats) {
        super(brand, model, year, rentalPrice);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}

// Child class 2
class Motorcycle extends Vehicle {
    private int engineCapacity;

    public Motorcycle(String brand, String model, int year, double rentalPrice, int engineCapacity) {
        super(brand, model, year, rentalPrice);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }
}

// Main class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        // Creating instances of Car and Motorcycle
        Car car = new Car("Toyota", "Camry", 2022, 50.0, 5);
        Motorcycle motorcycle = new Motorcycle("Honda", "CBR500R", 2021, 30.0, 500);

        // Displaying information of each vehicle
        car.displayInfo();
        System.out.println("Number of Seats: " + car.getNumberOfSeats());

        System.out.println(); // Adding a line break for better readability

        motorcycle.displayInfo();
        System.out.println("Engine Capacity: " + motorcycle.getEngineCapacity());
    }
}
