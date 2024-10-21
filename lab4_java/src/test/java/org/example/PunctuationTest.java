package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@code Punctuation} class.
 * This class contains test cases to verify the functionality of the {@code Punctuation} class methods.
 * It uses JUnit 5 for testing.
 *
 * @author Liliia Kozub
 * @version 1.0
 * @since 2024-10-19
 */
class PunctuationTest {

    /**
     * Tests the creation of a {@code Punctuation} object.
     * Verifies that the punctuation is created successfully and the character is set correctly.
     */
    @Test
    void testPunctuationCreation() {
        Punctuation punctuation = new Punctuation('!');
        assertNotNull(punctuation, "Punctuation should be created successfully");
        assertEquals('!', punctuation.getCharacter(), "Character should be '!'");
    }

    /**
     * Tests the {@code getCharacter} method of the {@code Punctuation} class.
     * Verifies that the method returns the correct character for a given punctuation.
     */
    @Test
    void testGetCharacter() {
        Punctuation punctuation = new Punctuation(',');
        assertEquals(',', punctuation.getCharacter(), "getCharacter() should return ','");
    }

    /**
     * Tests the {@code toString} method of the {@code Punctuation} class.
     * Verifies that the method returns the correct string representation of the punctuation.
     */
    @Test
    void testToString() {
        Punctuation punctuation = new Punctuation('.');
        assertEquals(".", punctuation.toString(), "toString() should return '.'");

        Punctuation exclamation = new Punctuation('?');
        assertEquals("?", exclamation.toString(), "toString() should return '?'");
    }
}
