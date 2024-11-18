package org.example;

import java.util.*;

/**
 * A set of cars that implements the {@link Set} interface.
 * This class is designed to store and manage a collection of {@link Car} objects. It supports dynamic resizing
 * of the internal array when the capacity is exceeded and provides all standard {@link Set} operations.
 * The set ensures that no duplicate cars are added.
 *
 * @param <T> the type of car that extends the {@link Car} class
 */
public class CarSet <T extends Car> implements Set<T> {

    /** The initial capacity of the car array */
    private static final int INITIAL_CAPACITY = 15;

    /** The factor by which the array will expand when its capacity is exceeded */
    private static final double EXPANSION_FACTOR = 1.3;

    /** The internal array to store the cars */
    private Car[] cars;

    /** The current number of cars in the set */
    private int size;

    /**
     * Constructs an empty {@link CarSet} with the initial capacity.
     */
    public CarSet() {
        cars = new Car[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Constructs a {@link CarSet} with a single car.
     *
     * @param car the car to add to the set
     */
    public CarSet(T car) {
        this();
        add(car);
    }

    /**
     * Constructs a {@link CarSet} containing the cars from the specified collection.
     *
     * @param cars a collection of cars to add to the set
     */
    public CarSet(Collection<? extends T> cars) {
        this();
        for (T car : cars) {
            add(car);
        }
    }

    /**
     * Expands the internal array by a factor of {@link #EXPANSION_FACTOR}.
     * This method is called when the array is full, and the set needs to accommodate more cars.
     */
    private void expandArray(){
        int newCapacity = (int) (cars.length * EXPANSION_FACTOR);
        cars = Arrays.copyOf(cars, newCapacity);
    }

    /**
     * Returns the number of cars in the set.
     *
     * @return the number of cars in the set
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns {@code true} if the set contains no cars.
     *
     * @return {@code true} if the set is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the set contains the specified car.
     *
     * @param o the car to check for containment
     * @return {@code true} if the set contains the specified car, {@code false} otherwise
     */
    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        for (int i = 0; i < size; i++)
            if (cars[i].equals(car)) return true;
        return false;
    }

    /**
     * Returns an iterator over the cars in the set.
     *
     * @return an iterator over the cars
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) cars[index++];
            }
        };
    }

    /**
     * Returns an array containing all the cars in the set.
     * The runtime type of the returned array is that of the specified array.
     *
     * @param a the array into which the elements of the set are to be stored
     * @param <T> the type of the array
     * @return an array containing all the cars in the set
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(cars, size, a.getClass());
        System.arraycopy(cars, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    /**
     * Returns an array containing all the cars in the set.
     *
     * @return an array containing all the cars in the set
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(cars, size);
    }

    /**
     * Adds a car to the set. If the set already contains the car, it will not be added.
     * If the array is full, the array will be expanded to accommodate the new car.
     *
     * @param car the car to add
     * @return {@code true} if the car was added, {@code false} if it was already present
     */
    @Override
    public boolean add(T car) {
        if(contains(car))
            return false;
        if (size == cars.length) {
            expandArray();
        }
        cars[size++] = car;
        return true;
    }

    /**
     * Removes a car from the set.
     *
     * @param o the car to remove
     * @return {@code true} if the car was removed, {@code false} if the car was not found
     */
    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        for (int i = 0; i < size; i++) {
            if (cars[i].equals(car)) {
                cars[i] = cars[size - 1];
                cars[--size] = null; // Clears the removed element
                return true;
            }
        }
        return false;
    }

    /**
     * Returns {@code true} if the set contains all the cars in the specified collection.
     *
     * @param c the collection of cars to check for containment
     * @return {@code true} if the set contains all the cars, {@code false} otherwise
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o))
                return false;
        }
        return true;
    }

    /**
     * Adds all cars from the specified collection to the set.
     *
     * @param c the collection of cars to add
     * @return {@code true} if the set was modified as a result of the call
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean changed = false;
        for (T t : c) {
            if (add(t))
                changed = true;
        }
        return changed;
    }

    /**
     * Removes all cars in the specified collection from the set.
     *
     * @param c the collection of cars to remove
     * @return {@code true} if the set was modified as a result of the call
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        for (Object o : c) {
            if (remove(o))
                changed = true;
        }
        return changed;
    }

    /**
     * Retains only the cars in the set that are contained in the specified collection.
     *
     * @param c the collection of cars to retain
     * @return {@code true} if the set was modified as a result of the call
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean changed = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(cars[i])) {
                remove(cars[i]);
                i--;
                changed = true;
            }
        }
        return changed;
    }

    /**
     * Clears all cars from the set.
     * The set will be empty after this operation.
     */
    @Override
    public void clear() {
        Arrays.fill(cars, 0, size, null);
        size = 0;
    }

    /**
     * Returns the internal array of cars.
     *
     * @return the array of cars
     */
    public Car[] getCars() {
        return cars;
    }
}

