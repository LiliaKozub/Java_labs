package org.example;

/**
 * The CarValidationException class is a custom exception that is thrown to indicate
 * validation errors related to car properties (e.g., price, fuel consumption, max speed).
 * This exception extends the standard Exception class.
 */
public class CarValidationException extends Exception {

    /**
     * Constructs a CarValidationException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public CarValidationException(String message) {
        super(message);
    }
}
