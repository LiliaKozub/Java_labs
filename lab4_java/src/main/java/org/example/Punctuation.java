package org.example;

/**
 * The {@code Punctuation} class represents a punctuation mark as a character.
 * <p>
 * This class is part of the {@link SentenceElement} interface and is used to
 * handle punctuation characters within a sentence.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     Punctuation punctuation = new Punctuation('.');
 *     System.out.println(punctuation);           // Outputs '.'
 * </pre>
 *
 * @author Liliia Kozub
 * @version 1.0
 * @since 2024-10-19
 */
public class Punctuation implements SentenceElement {

    /**
     * The character representing the punctuation mark.
     */
    private char character;

    /**
     * Constructs a {@code Punctuation} object that represents the given punctuation character.
     *
     * @param character the punctuation character
     */
    public Punctuation(char character) {
        this.character = character;
    }

    /**
     * Returns the punctuation character represented by this object.
     *
     * @return the character representing the punctuation mark
     */
    public char getCharacter() {
        return character;
    }

    /**
     * Returns the string representation of the punctuation character.
     *
     * @return a string containing the punctuation character
     */
    @Override
    public String toString() {
        return String.valueOf(character);
    }
}

