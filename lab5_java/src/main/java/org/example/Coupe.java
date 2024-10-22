package org.example;

/**
 * The Coupe class represents a type of car that has a sporty design and typically two doors.
 * It extends the Car class, inheriting its properties and behaviors.
 */
public class Coupe extends Car {

    /**
     * Constructs a Coupe object with the specified model, price, fuel consumption, and maximum speed.
     *
     * @param model          the model of the coupe
     * @param price          the price of the coupe in dollars
     * @param fuelConsumption the fuel consumption of the coupe in liters per 100 kilometers
     * @param maxSpeed       the maximum speed of the coupe in kilometers per hour
     * @throws CarValidationException if any of the parameters are invalid, such as negative or zero values
     */
    public Coupe(String model, double price, double fuelConsumption, double maxSpeed) throws CarValidationException {
        super(model, price, fuelConsumption, maxSpeed);
    }

    /**
     * Returns a string representation of the Coupe object, including its type and inherited properties.
     *
     * @return a string describing the coupe
     */
    @Override
    public String toString() {
        return "Coupe - " + super.toString();
    }
}
