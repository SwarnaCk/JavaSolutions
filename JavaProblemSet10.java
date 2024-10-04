class Vehicle {
    protected String make;
    protected int year;

    public Vehicle(String make, int year) {
        this.make = make;
        this.year = year;
    }
}

class Car extends Vehicle {
    private String model;

    public Car(String make, int year, String model) {
        super(make, year); 
        this.model = model;
    }

    public void printCarDetails() {
        System.out.println("Car Details:");
        System.out.println("Make: " + make);
        System.out.println("Year: " + year);
        System.out.println("Model: " + model);
    }
}

public class JavaProblemSet10 {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", 2022, "Camry");

        myCar.printCarDetails();
    }
}