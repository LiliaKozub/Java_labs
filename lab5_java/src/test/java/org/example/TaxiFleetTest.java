package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The TaxiFleetTest class contains unit tests for the TaxiFleet class.
 * It tests the functionality of calculating total price, sorting by fuel consumption,
 * and finding cars by speed range.
 */
class TaxiFleetTest {

    /**
     * Tests the calculation of the total price of the cars in the taxi fleet.
     *
     * @throws CarValidationException if any car parameters are invalid (should not be thrown in this test)
     */
    @Test
    void testCalculateTotalPrice() throws CarValidationException {
        Car[] cars = {
                new Car("Audi TT", 35000, 8.5, 240),
                new Car("Mercedes-Benz C-Class Coupe", 42000, 8.0, 250),
                new Car("Ford Mustang", 45000, 9.5, 260)
        };
        TaxiFleet taxiFleet = new TaxiFleet(cars);

        double expectedTotalPrice = 35000 + 42000 + 45000;
        assertEquals(expectedTotalPrice, taxiFleet.calculateTotalPrice());
    }

    /**
     * Tests the sorting of cars in the taxi fleet by fuel consumption.
     *
     * @throws CarValidationException if any car parameters are invalid (should not be thrown in this test)
     */
    @Test
    void testSortByFuelConsumption() throws CarValidationException {
        Car[] cars = {
                new Car("Audi TT", 35000, 8.5, 240),
                new Car("Ford Mustang", 45000, 9.5, 260),
                new Car("Mercedes-Benz C-Class Coupe", 42000, 8.0, 250)
        };
        TaxiFleet taxiFleet = new TaxiFleet(cars);

        taxiFleet.sortByFuelConsumption();

        assertEquals("Mercedes-Benz C-Class Coupe", cars[0].getModel());
        assertEquals("Audi TT", cars[1].getModel());
        assertEquals("Ford Mustang", cars[2].getModel());
    }

    /**
     * Tests finding cars within a valid speed range.
     *
     * @throws Exception if any car parameters are invalid (should not be thrown in this test)
     */
    @Test
    void testFindCarsBySpeedRangeValid() throws Exception {
        Car[] cars = {
                new Car("Audi TT", 35000, 8.5, 240),
                new Car("Ford Mustang", 45000, 9.5, 260),
                new Car("Mercedes-Benz C-Class Coupe", 42000, 8.0, 250)
        };
        TaxiFleet taxiFleet = new TaxiFleet(cars);

        Car[] foundCars = taxiFleet.findCarsBySpeedRange(240, 260);
        assertEquals(3, foundCars.length);
    }

    /**
     * Tests finding cars within a speed range that results in no cars being found.
     *
     * @throws CarValidationException if any car parameters are invalid (should not be thrown in this test)
     */
    @Test
    void testFindCarsBySpeedRangeNoCars() throws CarValidationException {
        Car[] cars = {
                new Car("Audi TT", 35000, 8.5, 240),
                new Car("Ford Mustang", 45000, 9.5, 260)
        };
        TaxiFleet taxiFleet = new TaxiFleet(cars);

        Exception exception = assertThrows(CarValidationException.class, () -> {
            taxiFleet.findCarsBySpeedRange(300, 400);
        });
        assertEquals("No cars found in the speed range [300.0; 400.0].", exception.getMessage());
    }

    /**
     * Tests finding cars with a negative speed range, which should throw an exception.
     *
     * @throws CarValidationException if any car parameters are invalid (should not be thrown in this test)
     */
    @Test
    void testFindCarsBySpeedRangeNegativeSpeed() throws CarValidationException {
        Car[] cars = {
                new Car("Audi TT", 35000, 8.5, 240),
                new Car("Ford Mustang", 45000, 9.5, 260)
        };
        TaxiFleet taxiFleet = new TaxiFleet(cars);

        Exception exception = assertThrows(CarValidationException.class, () -> {
            taxiFleet.findCarsBySpeedRange(-50, 100);
        });
        assertEquals("An erroneous attempt to find a car with a speed in range [-50.0; 100.0]. Speed values must be non-negative.", exception.getMessage());
    }

    /**
     * Tests finding cars with a lower speed bound greater than the upper bound, which should throw an exception.
     *
     * @throws CarValidationException if any car parameters are invalid (should not be thrown in this test)
     */
    @Test
    void testFindCarsBySpeedRangeLowerGreaterThanUpper() throws CarValidationException {
        Car[] cars = {
                new Car("Audi TT", 35000, 8.5, 240),
                new Car("Ford Mustang", 45000, 9.5, 260)
        };
        TaxiFleet taxiFleet = new TaxiFleet(cars);

        Exception exception = assertThrows(CarValidationException.class, () -> {
            taxiFleet.findCarsBySpeedRange(300, 100);
        });
        assertEquals("An erroneous attempt to find a car with a speed in range [300.0; 100.0]. Lower bound must be less than or equal to upper bound.", exception.getMessage());
    }
}
