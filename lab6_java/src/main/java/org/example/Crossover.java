package org.example;

/**
 * The Crossover class represents a type of car that combines characteristics of SUVs and passenger vehicles.
 * It extends the Car class, inheriting its properties and behaviors.
 */
public class Crossover extends Car {

    /**
     * Constructs a Crossover object with the specified model, price, fuel consumption, and maximum speed.
     *
     * @param model          the model of the crossover
     * @param price          the price of the crossover in dollars
     * @param fuelConsumption the fuel consumption of the crossover in liters per 100 kilometers
     * @param maxSpeed       the maximum speed of the crossover in kilometers per hour
     * @throws CarValidationException if any of the parameters are invalid, such as negative or zero values
     */
    public Crossover(String model, double price, double fuelConsumption, double maxSpeed) throws CarValidationException {
        super(model, price, fuelConsumption, maxSpeed);
    }

    /**
     * Returns a string representation of the Crossover object, including its type and inherited properties.
     *
     * @return a string describing the crossover
     */
    @Override
    public String toString() {
        return "Crossover - " + super.toString();
    }
}
