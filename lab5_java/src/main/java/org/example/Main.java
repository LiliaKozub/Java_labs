package org.example;

/**
 * The Main class serves as the entry point for the taxi fleet application.
 * It initializes a collection of car objects, creates a TaxiFleet,
 * and performs various operations such as displaying initial car information,
 * calculating total fleet cost, sorting cars by fuel consumption,
 * and finding cars within a specified speed range.
 */
public class Main {
    /**
     * The main method is the entry point of the application.
     * It initializes the car fleet, displays car information,
     * calculates the total price of the fleet, sorts the cars by fuel consumption,
     * and finds cars within a specific speed range.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            Car[] cars = {
                    new Coupe("Audi TT", 35000, 8.5, 240),
                    new Coupe("Mercedes-Benz C-Class Coupe", 42000, 8.0, 250),
                    new Coupe("Ford Mustang", 45000, 9.5, 260),
                    new Crossover("Toyota RAV4", 40000, 9.0, 200),
                    new Crossover("Nissan Rogue", 38000, 8.8, 195),
                    new Crossover("Mazda CX-5", 41000, 8.6, 210),
                    new Hatchback("Volkswagen Golf", 25000, 6.5, 190),
                    new Hatchback("Ford Focus", 23000, 6.0, 185),
                    new Hatchback("Hyundai i30", 24000, 5.8, 180),
                    new Minivan("Honda Odyssey", 45000, 10.0, 180),
                    new Minivan("Chrysler Pacifica", 47000, 9.8, 175),
                    new Minivan("Toyota Sienna", 48000, 9.5, 170),
                    new Sedan("BMW 3 Series", 37000, 7.2, 220),
                    new Sedan("Mercedes-Benz E-Class", 49000, 7.5, 230),
                    new Sedan("Audi A6", 52000, 7.8, 240),
                    new Sedan("Lexus ES", 53000, 7.4, 225),
                    new Coupe("Chevrolet Camaro", 46000, 9.2, 250),
                    new Hatchback("Kia Ceed", 22000, 5.9, 175),
                    new Crossover("Honda CR-V", 39000, 8.4, 205)
            };

            TaxiFleet taxiFleet = new TaxiFleet(cars);

            System.out.println("===== Initial Car Park Information =====");
            taxiFleet.printCars();

            double totalCost = taxiFleet.calculateTotalPrice();
            System.out.println("\nTotal cost of the car park: $" + totalCost);

            taxiFleet.sortByFuelConsumption();
            System.out.println("\n===== Car Park Sorted by Fuel Consumption =====");
            taxiFleet.printCars();

            double minSpeed = 180;
            double maxSpeed = 220;

            Car[] foundCars = taxiFleet.findCarsBySpeedRange(minSpeed, maxSpeed);
            System.out.println("\nFound cars in the speed range [" + minSpeed + " ;  " + maxSpeed + "]:");
            for (Car car : foundCars) {
                System.out.println(car);
            }

        } catch (CarValidationException e) {
            System.out.println("\nError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nAn unexpected error occurred: " + e.getMessage());
        }
    }
}
