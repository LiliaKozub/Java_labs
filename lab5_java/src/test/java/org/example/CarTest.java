package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The CarTest class contains unit tests for the Car class.
 * It tests the functionality of the Car constructor,
 * validation of parameters, and the toString method.
 */
class CarTest {

    /**
     * Tests the successful creation of a Car object with valid parameters.
     *
     * @throws CarValidationException if the parameters are invalid (should not be thrown in this test)
     */
    @Test
    void testCarCreationValid() throws CarValidationException {
        Car car = new Car("Audi TT", 35000, 8.5, 240);
        assertEquals("Audi TT", car.getModel());
        assertEquals(35000, car.getPrice());
        assertEquals(8.5, car.getFuelConsumption());
        assertEquals(240, car.getMaxSpeed());
    }

    /**
     * Tests that creating a Car with a negative price throws a CarValidationException.
     */
    @Test
    void testCarCreationNegativePrice() {
        Exception exception = assertThrows(CarValidationException.class, () -> {
            new Car("Audi TT", -35000, 8.5, 240);
        });
        assertEquals("Price must be positive.", exception.getMessage());
    }

    /**
     * Tests that creating a Car with a price of zero throws a CarValidationException.
     */
    @Test
    void testCarCreationZeroPrice() {
        Exception exception = assertThrows(CarValidationException.class, () -> {
            new Car("Audi TT", 0, 8.5, 240);
        });
        assertEquals("Price must be positive.", exception.getMessage());
    }

    /**
     * Tests that creating a Car with negative fuel consumption throws a CarValidationException.
     */
    @Test
    void testCarCreationNegativeFuelConsumption() {
        Exception exception = assertThrows(CarValidationException.class, () -> {
            new Car("Audi TT", 35000, -8.5, 240);
        });
        assertEquals("Fuel consumption must be positive.", exception.getMessage());
    }

    /**
     * Tests that creating a Car with zero fuel consumption throws a CarValidationException.
     */
    @Test
    void testCarCreationZeroFuelConsumption() {
        Exception exception = assertThrows(CarValidationException.class, () -> {
            new Car("Audi TT", 35000, 0, 240);
        });
        assertEquals("Fuel consumption must be positive.", exception.getMessage());
    }

    /**
     * Tests that creating a Car with negative maximum speed throws a CarValidationException.
     */
    @Test
    void testCarCreationNegativeMaxSpeed() {
        Exception exception = assertThrows(CarValidationException.class, () -> {
            new Car("Audi TT", 35000, 8.5, -240);
        });
        assertEquals("Max speed must be positive.", exception.getMessage());
    }

    /**
     * Tests that creating a Car with a maximum speed of zero throws a CarValidationException.
     */
    @Test
    void testCarCreationZeroMaxSpeed() {
        Exception exception = assertThrows(CarValidationException.class, () -> {
            new Car("Audi TT", 35000, 8.5, 0);
        });
        assertEquals("Max speed must be positive.", exception.getMessage());
    }

    /**
     * Tests the toString method of the Car class to ensure it returns the expected string representation.
     *
     * @throws CarValidationException if the parameters are invalid (should not be thrown in this test)
     */
    @Test
    void testToString() throws CarValidationException {
        Car car = new Car("Audi TT", 35000, 8.5, 240);
        String expectedString = "Model: Audi TT, Price: $35000.0, Fuel Consumption: 8.5 L/100km, Max Speed: 240.0 km/h";
        assertEquals(expectedString, car.toString());
    }
}
