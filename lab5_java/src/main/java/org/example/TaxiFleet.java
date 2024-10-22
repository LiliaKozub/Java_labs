package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The TaxiFleet class represents a fleet of cars for a taxi service.
 * It provides functionality to calculate the total price of the fleet,
 * sort cars by fuel consumption, find cars within a specified speed range,
 * and print details of all cars in the fleet.
 */
public class TaxiFleet {
    /**
     * An array of Car objects representing the cars in the fleet.
     */
    final private Car[] cars;

    /**
     * Constructs a TaxiFleet with the specified array of cars.
     *
     * @param cars an array of Car objects representing the fleet of cars
     */
    public TaxiFleet(Car[] cars) {
        this.cars = cars;
    }

    /**
     * Calculates the total price of all cars in the fleet.
     *
     * @return the total price of the cars in dollars
     */
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Car car : cars) {
            totalPrice += car.getPrice();
        }
        return totalPrice;
    }

    /**
     * Sorts the cars in the fleet by their fuel consumption in ascending order.
     */
    public void sortByFuelConsumption() {
        Arrays.sort(cars, Comparator.comparingDouble(Car::getFuelConsumption));
    }

    /**
     * Finds and returns an array of cars whose maximum speed falls within the specified range.
     *
     * @param lower the lower bound of the speed range (inclusive)
     * @param upper the upper bound of the speed range (inclusive)
     * @return an array of Car objects within the specified speed range
     * @throws CarValidationException if the speed values are negative or if the lower bound is greater than the upper bound,
     *                                or if no cars are found in the specified range
     */
    public Car[] findCarsBySpeedRange(double lower, double upper) throws Exception {
        if (lower < 0 || upper < 0) {
            throw new CarValidationException("An erroneous attempt to find a car with a speed in range [" + lower + "; " + upper + "]. Speed values must be non-negative.");
        }

        if (lower > upper) {
            throw new CarValidationException("An erroneous attempt to find a car with a speed in range [" + lower + "; " + upper + "]. Lower bound must be less than or equal to upper bound.");
        }

        Car[] foundCars = Arrays.stream(cars)
                .filter(car -> car.getMaxSpeed() >= lower && car.getMaxSpeed() <= upper)
                .toArray(Car[]::new);

        if (foundCars.length == 0) {
            throw new CarValidationException("No cars found in the speed range [" + lower + "; " + upper + "].");
        }

        return foundCars;
    }

    /**
     * Prints the details of all cars in the fleet to the console.
     */
    public void printCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
