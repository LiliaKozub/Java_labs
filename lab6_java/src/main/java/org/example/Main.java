package org.example;

import java.util.List;
import java.util.Scanner;

/**
 * The {@code Main} class is the entry point of the application, providing a console-based menu
 * for users to interact with a collection of {@link Car} objects. This class offers functionality
 * to manage a set of cars, including adding, removing, displaying, and performing other operations
 * on the car collection.
 * <p>
 * The program continues running until the user chooses to exit.
 * </p>
 */
public class Main {

    /**
     * The main method of the application.
     * <p>
     * It sets up the scanner for user input and creates a {@link CarSet} to store cars.
     * It also retrieves a list of demo cars using the {@link CarUtils#getDemoCars} method and displays
     * a menu for the user to select various car operations.
     * </p>
     *
     * @param args the command line arguments (unused).
     * @throws CarValidationException if a car operation fails due to invalid data.
     */
    public static void main(String[] args) throws CarValidationException {
        // Initialize the scanner and the set of cars
        Scanner scanner = new Scanner(System.in);
        CarSet<Car> carSet = new CarSet<>();

        // Get a list of demo cars
        List<Car> demoCars = CarUtils.getDemoCars();

        // Main loop for displaying menu and processing user choices
        while (true) {
            // Show the main menu
            CarUtils.showMenu();

            // Get the user's choice
            int choice = CarUtils.getUserChoice(scanner);
            scanner.nextLine();  // Consume the leftover newline character

            // Switch case to handle different user choices
            switch (choice) {
                case 1 -> CarUtils.addCar(scanner, carSet);                // Add a new car to the set
                case 2 -> CarUtils.removeCar(scanner, carSet);             // Remove a car from the set
                case 3 -> CarUtils.displayCars(carSet);                    // Display all cars in the set
                case 4 -> CarUtils.checkCarExistence(scanner, carSet);     // Check if a car exists in the set
                case 5 -> CarUtils.addDemoCars(carSet, demoCars);          // Add demo cars to the set
                case 6 -> CarUtils.clearCars(carSet);                      // Clear all cars from the set
                case 7 -> CarUtils.showSetSize(carSet);                    // Show the number of cars in the set
                case 8 -> CarUtils.checkIfEmpty(carSet);                   // Check if the car set is empty
                case 9 -> CarUtils.retainDemoCars(carSet, demoCars);       // Retain only demo cars in the set
                case 10 -> {
                    CarUtils.exit(scanner);                               // Exit the program
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");  // Handle invalid input
            }
        }
    }
}
