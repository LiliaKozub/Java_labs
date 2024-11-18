package org.example;
import java.util.Objects;

/**
 * Represents a car with a model, price, fuel consumption, and maximum speed.
 * <p>
 * This class includes validation for the price, fuel consumption, and maximum speed to ensure
 * they are positive values.
 * </p>
 */
public class Car {
    /** The model of the car. */
    private final String model;

    /** The price of the car in dollars. Must be a positive value. */
    private final double price;

    /** The fuel consumption of the car in liters per 100 kilometers. Must be a positive value. */
    private final double fuelConsumption;

    /** The maximum speed of the car in kilometers per hour. Must be a positive value. */
    private final double maxSpeed;

    /**
     * Constructs a new Car with the specified model, price, fuel consumption, and maximum speed.
     *
     * @param model           the model of the car
     * @param price           the price of the car, must be positive
     * @param fuelConsumption the fuel consumption of the car, must be positive
     * @param maxSpeed       the maximum speed of the car, must be positive
     * @throws CarValidationException if the price, fuel consumption, or maximum speed is not positive
     */
    public Car(String model, double price, double fuelConsumption, double maxSpeed) throws CarValidationException {
        if (price <= 0) {
            throw new CarValidationException("Price must be positive.");
        }
        if (fuelConsumption <= 0) {
            throw new CarValidationException("Fuel consumption must be positive.");
        }
        if (maxSpeed <= 0) {
            throw new CarValidationException("Max speed must be positive.");
        }
        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
    }

    /**
     * Returns the model of the car.
     *
     * @return the model of the car
     */
    public String getModel() {
        return model;
    }

    /**
     * Returns the price of the car.
     *
     * @return the price of the car
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the fuel consumption of the car.
     *
     * @return the fuel consumption of the car
     */
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Returns the maximum speed of the car.
     *
     * @return the maximum speed of the car
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Returns a string representation of the car, including its model, price, fuel consumption,
     * and maximum speed.
     *
     * @return a string representation of the car
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return Double.compare(car.price, price) == 0 &&
                Double.compare(car.fuelConsumption, fuelConsumption) == 0 &&
                maxSpeed == car.maxSpeed &&
                model.equals(car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price, fuelConsumption, maxSpeed);
    }

    @Override
    public String toString() {
        return "Model: " + model + ", Price: $" + price + ", Fuel Consumption: " + fuelConsumption + " L/100km, Max Speed: " + maxSpeed + " km/h";
    }
}

