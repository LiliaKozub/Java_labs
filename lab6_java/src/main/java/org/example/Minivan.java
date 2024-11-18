package org.example;

/**
 * The Minivan class represents a type of car designed for transporting passengers, typically featuring
 * a spacious interior and multiple seating configurations. It extends the Car class, inheriting its properties and behaviors.
 */
public class Minivan extends Car {

    /**
     * Constructs a Minivan object with the specified model, price, fuel consumption, and maximum speed.
     *
     * @param model           the model of the minivan
     * @param price           the price of the minivan in dollars
     * @param fuelConsumption  the fuel consumption of the minivan in liters per 100 kilometers
     * @param maxSpeed        the maximum speed of the minivan in kilometers per hour
     * @throws CarValidationException if any of the parameters are invalid, such as negative or zero values
     */
    public Minivan(String model, double price, double fuelConsumption, double maxSpeed) throws CarValidationException {
        super(model, price, fuelConsumption, maxSpeed);
    }

    /**
     * Returns a string representation of the Minivan object, including its type and inherited properties.
     *
     * @return a string describing the minivan
     */
    @Override
    public String toString() {
        return "Minivan - " + super.toString();
    }
}

