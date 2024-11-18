package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link CarSet} class, testing the core operations of adding, removing,
 * and manipulating a collection of {@link Car} objects. These tests ensure that the
 * {@link CarSet} behaves correctly when interacting with the car objects.
 * <p>
 * The {@code CarSetTest} class contains various test methods that verify the functionality
 * of the {@code CarSet} class, including adding, removing, and checking the contents of the set.
 * </p>
 */
class CarSetTest {

    /**
     * The {@code CarSet} object used for testing.
     */
    private CarSet<Car> carSet;

    /**
     * A predefined list of cars used for testing.
     */
    private List<Car> carList;

    /**
     * Initializes the test environment by creating a new {@code CarSet} instance and
     * populating a list of car objects to be used in various test cases.
     *
     * @throws CarValidationException if there is an error while adding a car.
     */
    @BeforeEach
    void setUp() throws CarValidationException {
        carSet = new CarSet<>();
        carList = Arrays.asList(
                new Coupe("Audi TT", 35000, 8.5, 240),
                new Coupe("Ford Mustang", 45000, 9.5, 260),
                new Crossover("Toyota RAV4", 40000, 9.0, 200),
                new Sedan("BMW 3 Series", 37000, 7.2, 220),
                new Minivan("Honda Odyssey", 45000, 10.0, 180),
                new Sedan("Audi A4", 41000, 7.0, 230),
                new Hatchback("Volkswagen Golf", 29000, 6.5, 210),
                new Crossover("Mazda CX-5", 38000, 8.0, 210),
                new Minivan("Kia Carnival", 47000, 9.8, 190),
                new Coupe("Chevrolet Camaro", 46000, 9.2, 270)
        );
    }

    /**
     * Tests adding a car to the set, including duplicate handling.
     *
     * @throws CarValidationException if the car is invalid or cannot be added.
     */
    @Test
    void testAdd() throws CarValidationException {
        Car car = new Coupe("Audi TT", 35000, 8.5, 240);
        assertTrue(carSet.add(car));
        assertTrue(carSet.contains(car));
        assertFalse(carSet.add(car)); // Duplicate
        assertEquals(1, carSet.size());
    }

    /**
     * Tests removing a car from the set and verifying that it is no longer present.
     *
     * @throws CarValidationException if the car is invalid or cannot be removed.
     */
    @Test
    void testRemove() throws CarValidationException {
        Car car = new Sedan("BMW 3 Series", 37000, 7.2, 220);
        carSet.add(car);
        assertTrue(carSet.remove(car));
        assertFalse(carSet.contains(car));
        assertEquals(0, carSet.size());
    }

    /**
     * Tests the size of the car set after adding cars.
     */
    @Test
    void testSize() {
        assertEquals(0, carSet.size());
        carSet.addAll(carList);
        assertEquals(carList.size(), carSet.size());
    }

    /**
     * Tests checking if the car set is empty.
     */
    @Test
    void testIsEmpty() {
        assertTrue(carSet.isEmpty());
        carSet.add(carList.get(0));
        assertFalse(carSet.isEmpty());
    }

    /**
     * Tests whether the car set contains a specific car.
     *
     * @throws CarValidationException if the car is invalid.
     */
    @Test
    void testContains() throws CarValidationException {
        Car car = new Coupe("Ford Mustang", 45000, 9.5, 260);
        assertFalse(carSet.contains(car));
        carSet.add(car);
        assertTrue(carSet.contains(car));
    }

    /**
     * Tests iterating over the car set using an iterator.
     */
    @Test
    void testIterator() {
        carSet.addAll(carList);
        Iterator<Car> iterator = carSet.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            assertNotNull(iterator.next());
            count++;
        }
        assertEquals(carSet.size(), count);
    }

    /**
     * Tests converting the car set to an array of {@link Car} objects.
     */
    @Test
    void testToArray() {
        carSet.addAll(carList);
        Object[] carsArray = carSet.toArray();
        assertEquals(carSet.size(), carsArray.length);
        assertTrue(Arrays.asList(carsArray).containsAll(carList));
    }

    /**
     * Tests converting the car set to an array of {@link Car} objects with a specified type.
     */
    @Test
    void testToArrayWithParameter() {
        carSet.addAll(carList);
        Car[] carsArray = carSet.toArray(new Car[0]);
        assertEquals(carSet.size(), carsArray.length);
        assertTrue(Arrays.asList(carsArray).containsAll(carList));
    }

    /**
     * Tests whether the car set contains all cars in the specified list.
     *
     * @throws CarValidationException if the car is invalid.
     */
    @Test
    void testContainsAll() throws CarValidationException {
        carSet.addAll(carList);
        assertTrue(carSet.containsAll(carList));
        List<Car> additionalCars = Collections.singletonList(new Coupe("Tesla Model S", 80000, 4.0, 250));
        assertFalse(carSet.containsAll(additionalCars));
    }

    /**
     * Tests adding a collection of cars to the set.
     */
    @Test
    void testAddAll() {
        assertTrue(carSet.addAll(carList));
        assertEquals(carList.size(), carSet.size());
        assertFalse(carSet.addAll(carList)); // No duplicates should be added
    }

    /**
     * Tests removing a collection of cars from the set.
     */
    @Test
    void testRemoveAll() {
        carSet.addAll(carList);
        assertTrue(carSet.removeAll(carList));
        assertTrue(carSet.isEmpty());
    }

    /**
     * Tests retaining only a specified collection of cars in the set.
     */
    @Test
    void testRetainAll() {
        carSet.addAll(carList);
        List<Car> retainedCars = Arrays.asList(carList.get(0), carList.get(1));
        assertTrue(carSet.retainAll(retainedCars));
        assertEquals(retainedCars.size(), carSet.size());
        assertTrue(carSet.containsAll(retainedCars));
    }

    /**
     * Tests clearing all cars from the set.
     */
    @Test
    void testClear() {
        carSet.addAll(carList);
        carSet.clear();
        assertTrue(carSet.isEmpty());
        assertEquals(0, carSet.size());
    }

    /**
     * Tests creating a {@link CarSet} with an initial car.
     *
     * @throws CarValidationException if the car is invalid.
     */
    @Test
    void testCarSetWithInitialCar() throws CarValidationException {
        Car car = new Coupe("Audi TT", 35000, 8.5, 240);
        CarSet<Car> carSetWithInitial = new CarSet<>(car);
        assertEquals(1, carSetWithInitial.size());
        assertTrue(carSetWithInitial.contains(car));
    }

    /**
     * Tests creating a {@link CarSet} from an existing collection of cars.
     */
    @Test
    void testCarSetWithCollection() {
        CarSet<Car> carSetWithCollection = new CarSet<>(carList);
        assertEquals(carList.size(), carSetWithCollection.size());
        assertTrue(carSetWithCollection.containsAll(carList));
    }

    /**
     * Tests the initial capacity of the car set.
     */
    @Test
    public void testInitialCapacity() {
        assertEquals(15, carSet.getCars().length, "Initial array capacity should be 15.");
    }

    /**
     * Tests that the car set expands its array when more cars are added than the initial capacity.
     *
     * @throws CarValidationException if the car is invalid.
     */
    @Test
    public void testArrayExpansion() throws CarValidationException {
        for (int i = 0; i < 15; i++) {
            carSet.add(new Car("Car " + i, 30000 + i, 7.5, 220));
        }

        assertEquals(15, carSet.getCars().length, "Array capacity should still be 15 after adding 15 elements.");

        carSet.add(new Car("Car 15", 35000, 8.0, 240));

        int expectedNewCapacity = (int) (15 * 1.3); // 15 * 1.3 = 19.5, rounded to 19
        assertEquals(expectedNewCapacity, carSet.getCars().length, "Array capacity should be expanded to 19 after adding 16th element.");
    }
}
