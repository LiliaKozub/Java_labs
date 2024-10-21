package org.example;

/**
 * The {@code Letter} class represents a single character
 * and provides methods to retrieve the character, convert it to lowercase,
 * and return its string representation.
 * <p>
 * This class is designed to encapsulate a single character and provide additional
 * functionality such as conversion to lowercase using the {@link Character} class methods.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     Letter letter = new Letter('A');
 *     System.out.println(letter.toLowerCase()); // Outputs 'a'
 *     System.out.println(letter);              // Outputs 'A'
 * </pre>
 *
 * @author Liliia Kozub
 * @version 1.0
 * @since 2024-10-19
 */
public class Letter {

    /**
     * The character stored by this {@code Letter} object.
     */
    private char character;

    /**
     * Constructs a new {@code Letter} object with the specified character.
     *
     * @param character the character to be stored in this {@code Letter} object
     */
    public Letter(char character) {
        this.character = character;
    }

    /**
     * Returns the character stored in this {@code Letter} object.
     *
     * @return the character stored in this object
     */
    public char getCharacter() {
        return character;
    }

    /**
     * Converts the stored character to lowercase.
     * <p>
     * This method uses the {@link Character#toLowerCase(char)} method to convert
     * the character to its lowercase equivalent, if applicable.
     * </p>
     *
     * @return the lowercase equivalent of the stored character, or the same character
     *         if it has no lowercase equivalent
     * @see Character#toLowerCase(char)
     */
    public char toLowerCase() {
        return Character.toLowerCase(character);
    }

    /**
     * Returns a string representation of this {@code Letter} object.
     * <p>
     * The string representation consists of the character stored in this object.
     * </p>
     *
     * @return a string containing the stored character
     */
    @Override
    public String toString() {
        return String.valueOf(character);
    }
}