package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@code Letter} class.
 * This class contains test cases to verify the functionality of the {@code Letter} class methods.
 * It uses JUnit 5 for testing.
 *
 * @author Liliia Kozub
 * @version 1.0
 * @since 2024-10-19
 */
class LetterTest {

    /**
     * Tests the creation of a {@code Letter} object.
     * Verifies that the letter is created successfully and the character is set correctly.
     */
    @Test
    void testLetterCreation() {
        Letter letter = new Letter('A');
        assertNotNull(letter, "Letter should be created successfully");
        assertEquals('A', letter.getCharacter(), "Character should be 'A'");
    }

    /**
     * Tests the {@code getCharacter} method of the {@code Letter} class.
     * Verifies that the method returns the correct character for a given letter.
     */
    @Test
    void testGetCharacter() {
        Letter letter = new Letter('b');
        assertEquals('b', letter.getCharacter(), "getCharacter() should return 'b'");
    }

    /**
     * Tests the {@code toLowerCase} method of the {@code Letter} class.
     * Verifies that the method correctly converts uppercase letters to lowercase
     * and returns lowercase letters unchanged.
     */
    @Test
    void testToLowerCase() {
        Letter upperCaseLetter = new Letter('C');
        assertEquals('c', upperCaseLetter.toLowerCase(), "toLowerCase() should return 'c'");

        Letter lowerCaseLetter = new Letter('d');
        assertEquals('d', lowerCaseLetter.toLowerCase(), "toLowerCase() should return 'd'");
    }

    /**
     * Tests the {@code toString} method of the {@code Letter} class.
     * Verifies that the method returns the correct string representation of the letter.
     */
    @Test
    void testToString() {
        Letter letter = new Letter('e');
        assertEquals("e", letter.toString(), "toString() should return 'e'");

        Letter specialCharacter = new Letter('@');
        assertEquals("@", specialCharacter.toString(), "toString() should return '@'");
    }
}
