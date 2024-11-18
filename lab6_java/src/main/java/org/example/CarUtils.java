package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Utility class providing a set of operations for managing a collection of cars.
 * Operations include adding, removing, displaying, and checking cars in the set.
 */
public class CarUtils {

    /**
     * Displays the menu options for the CarSet operations.
     */
    public static void showMenu() {
        System.out.println("\n--- CarSet Menu ---");
        System.out.println("1. Add a car");
        System.out.println("2. Remove a car");
        System.out.println("3. Display all cars");
        System.out.println("4. Check if a car exists");
        System.out.println("5. Add demo cars");
        System.out.println("6. Clear all cars");
        System.out.println("7. Size of the set");
        System.out.println("8. Check if empty");
        System.out.println("9. Retain specific cars");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Prompts the user to enter a choice and returns the corresponding integer.
     *
     * @param scanner the {@code Scanner} object used to read user input.
     * @return the user input as an integer, or -1 if the input is invalid.
     */
    public static int getUserChoice(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    /**
     * Returns a list of demo cars for the CarSet.
     *
     * @return a list of demo cars.
     * @throws CarValidationException if the car details are invalid.
     */
    public static List<Car> getDemoCars() throws CarValidationException {
        return Arrays.asList(
                new Coupe("Audi TT", 35000, 8.5, 240),
                new Coupe("Ford Mustang", 45000, 9.5, 260),
                new Crossover("Toyota RAV4", 40000, 9.0, 200),
                new Sedan("BMW 3 Series", 37000, 7.2, 220),
                new Minivan("Honda Odyssey", 45000, 10.0, 180),
                new Sedan("Audi A4", 41000, 7.0, 230),
                new Hatchback("Volkswagen Golf", 29000, 6.5, 210),
                new Crossover("Mazda CX-5", 38000, 8.0, 210),
                new Minivan("Kia Carnival", 47000, 9.8, 190),
                new Coupe("Chevrolet Camaro", 46000, 9.2, 270)
        );
    }

    /**
     * Prompts the user for car details and attempts to add the car to the specified set.
     *
     * @param scanner the {@code Scanner} object used to read user input.
     * @param carSet the {@code CarSet} to add the car to.
     */
    public static void addCar(Scanner scanner, CarSet<Car> carSet) {
        System.out.println("Enter car details to add:");
        try {
            Car carToAdd = promptForCarDetails(scanner);
            if (carSet.add(carToAdd)) {
                System.out.println("Car added to the set.");
            } else {
                System.out.println("Car already exists in the set.");
            }
        } catch (CarValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Prompts the user for car details and attempts to remove the car from the specified set.
     *
     * @param scanner the {@code Scanner} object used to read user input.
     * @param carSet the {@code CarSet} to remove the car from.
     */
    public static void removeCar(Scanner scanner, CarSet<Car> carSet) {
        System.out.println("Enter car details to remove:");
        try {
            Car carToRemove = promptForCarDetails(scanner);
            if (carSet.remove(carToRemove)) {
                System.out.println("Car removed from the set.");
            } else {
                System.out.println("Car not found in the set.");
            }
        } catch (CarValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Displays all cars in the specified car set.
     *
     * @param carSet the {@code CarSet} to display.
     */
    public static void displayCars(CarSet<Car> carSet) {
        if (carSet.isEmpty()) {
            System.out.println("The car set is empty.");
        } else {
            System.out.println("Cars in the set:");
            carSet.forEach(System.out::println);
        }
    }

    /**
     * Prompts the user for car details and checks if the car exists in the specified set.
     *
     * @param scanner the {@code Scanner} object used to read user input.
     * @param carSet the {@code CarSet} to check.
     */
    public static void checkCarExistence(Scanner scanner, CarSet<Car> carSet) {
        System.out.println("Enter car details to check existence:");
        try {
            Car carToCheck = promptForCarDetails(scanner);
            if (carSet.contains(carToCheck)) {
                System.out.println("Car exists in the set.");
            } else {
                System.out.println("Car does not exist in the set.");
            }
        } catch (CarValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Adds demo cars to the specified car set.
     *
     * @param carSet the {@code CarSet} to add demo cars to.
     * @param demoCars the list of demo cars to add.
     */
    public static void addDemoCars(CarSet<Car> carSet, List<Car> demoCars) {
        carSet.addAll(demoCars);
        System.out.println("Demo cars added.");
    }

    /**
     * Clears all cars from the specified car set.
     *
     * @param carSet the {@code CarSet} to clear.
     */
    public static void clearCars(CarSet<Car> carSet) {
        carSet.clear();
        System.out.println("All cars cleared from the set.");
    }

    /**
     * Displays the size of the car set.
     *
     * @param carSet the {@code CarSet} whose size is to be displayed.
     */
    public static void showSetSize(CarSet<Car> carSet) {
        System.out.println("Size of the set: " + carSet.size());
    }

    /**
     * Checks if the car set is empty.
     *
     * @param carSet the {@code CarSet} to check.
     */
    public static void checkIfEmpty(CarSet<Car> carSet) {
        System.out.println("Is the set empty? " + carSet.isEmpty());
    }

    /**
     * Retains only the first 3 demo cars in the set.
     *
     * @param carSet the {@code CarSet} to retain cars in.
     * @param demoCars the list of demo cars to retain.
     */
    public static void retainDemoCars(CarSet<Car> carSet, List<Car> demoCars) {
        System.out.println("Retaining only the first 3 demo cars...");
        carSet.retainAll(demoCars.subList(0, 3));
        System.out.println("Cars retained.");
    }

    /**
     * Exits the application and closes the scanner.
     *
     * @param scanner the {@code Scanner} to close.
     */
    public static void exit(Scanner scanner) {
        System.out.println("Exiting...");
        scanner.close();
    }

    /**
     * Prompts the user for car details and creates a {@code Car} object.
     *
     * @param scanner the {@code Scanner} used to read user input.
     * @return a {@code Car} object created from the user's input.
     * @throws CarValidationException if the car details are invalid.
     */
    private static Car promptForCarDetails(Scanner scanner) throws CarValidationException {
        String type = promptForCarType(scanner);
        String model = promptForCarModel(scanner);
        double price = promptForCarPrice(scanner);
        double fuelConsumption = promptForFuelConsumption(scanner);
        int maxSpeed = promptForMaxSpeed(scanner);
        return createCar(type, model, price, fuelConsumption, maxSpeed);
    }

    /**
     * Prompts the user for the car type and validates the input.
     *
     * @param scanner the {@code Scanner} used to read user input.
     * @return the car type input by the user.
     */
    private static String promptForCarType(Scanner scanner) {
        String type;
        while (true) {
            System.out.print("Enter car type (e.g., coupe, sedan, crossover, minivan, hatchback): ");
            type = scanner.nextLine().trim();
            if (Arrays.asList("coupe", "sedan", "crossover", "minivan", "hatchback").contains(type.toLowerCase())) {
                return type;
            }
            System.out.println("Invalid car type. Please enter a valid type.");
        }
    }

    /**
     * Prompts the user for the car model.
     *
     * @param scanner the {@code Scanner} used to read user input.
     * @return the car model input by the user.
     */
    private static String promptForCarModel(Scanner scanner) {
        System.out.print("Enter car model: ");
        return scanner.nextLine().trim();
    }

    /**
     * Prompts the user for the car price.
     *
     * @param scanner the {@code Scanner} used to read user input.
     * @return the car price input by the user.
     */
    private static double promptForCarPrice(Scanner scanner) {
        double price;
        while (true) {
            System.out.print("Enter car price: ");
            try {
                price = scanner.nextDouble();
                if (price > 0) {
                    return price;
                } else {
                    System.out.println("Price must be positive. Please enter a valid price.");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a valid price.");
            }
        }
    }

    /**
     * Prompts the user for the car fuel consumption.
     *
     * @param scanner the {@code Scanner} used to read user input.
     * @return the car fuel consumption input by the user.
     */
    private static double promptForFuelConsumption(Scanner scanner) {
        double fuelConsumption;
        while (true) {
            System.out.print("Enter car fuel consumption (liters per 100 km): ");
            try {
                fuelConsumption = scanner.nextDouble();
                if (fuelConsumption > 0) {
                    return fuelConsumption;
                } else {
                    System.out.println("Fuel consumption must be positive. Please enter a valid value.");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a valid fuel consumption.");
            }
        }
    }

    /**
     * Prompts the user for the car's maximum speed.
     *
     * @param scanner the {@code Scanner} used to read user input.
     * @return the car's maximum speed input by the user.
     */
    private static int promptForMaxSpeed(Scanner scanner) {
        int maxSpeed;
        while (true) {
            System.out.print("Enter car maximum speed (km/h): ");
            try {
                maxSpeed = scanner.nextInt();
                if (maxSpeed > 0) {
                    return maxSpeed;
                } else {
                    System.out.println("Max speed must be positive. Please enter a valid value.");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a valid maximum speed.");
            }
        }
    }

    /**
     * Creates a car based on the specified type and details.
     *
     * @param type the car type (e.g., coupe, sedan, etc.).
     * @param model the car model.
     * @param price the car price.
     * @param fuelConsumption the car's fuel consumption.
     * @param maxSpeed the car's maximum speed.
     * @return the created {@code Car} object.
     * @throws CarValidationException if the car details are invalid.
     */
    private static Car createCar(String type, String model, double price, double fuelConsumption, int maxSpeed) throws CarValidationException {
        switch (type.toLowerCase()) {
            case "coupe":
                return new Coupe(model, price, fuelConsumption, maxSpeed);
            case "sedan":
                return new Sedan(model, price, fuelConsumption, maxSpeed);
            case "crossover":
                return new Crossover(model, price, fuelConsumption, maxSpeed);
            case "minivan":
                return new Minivan(model, price, fuelConsumption, maxSpeed);
            case "hatchback":
                return new Hatchback(model, price, fuelConsumption, maxSpeed);
            default:
                throw new CarValidationException("Invalid car type.");
        }
    }
}
