package org.example;

/**
 * The Hatchback class represents a type of car characterized by its compact size and a rear door that swings upward.
 * It extends the Car class, inheriting its properties and behaviors.
 */
public class Hatchback extends Car {

    /**
     * Constructs a Hatchback object with the specified model, price, fuel consumption, and maximum speed.
     *
     * @param model          the model of the hatchback
     * @param price          the price of the hatchback in dollars
     * @param fuelConsumption the fuel consumption of the hatchback in liters per 100 kilometers
     * @param maxSpeed       the maximum speed of the hatchback in kilometers per hour
     * @throws CarValidationException if any of the parameters are invalid, such as negative or zero values
     */
    public Hatchback(String model, double price, double fuelConsumption, double maxSpeed) throws CarValidationException {
        super(model, price, fuelConsumption, maxSpeed);
    }

    /**
     * Returns a string representation of the Hatchback object, including its type and inherited properties.
     *
     * @return a string describing the hatchback
     */
    @Override
    public String toString() {
        return "Hatchback - " + super.toString();
    }
}


