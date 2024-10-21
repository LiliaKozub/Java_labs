package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@code Word} class.
 * This class contains test cases to verify the functionality of the Word class,
 * including creation, comparison, and formatting methods.
 *
 * @author Liliia Kozub
 * @version 1.0
 * @since 2024-10-19
 */
class WordTest {

    /**
     * Tests the creation of a Word object.
     * Verifies that the word is created successfully and the correct value is returned.
     */
    @Test
    void testWordCreation() {
        Word word = new Word("Hello");
        assertNotNull(word, "Word should be created successfully");
        assertEquals("Hello", word.getWord(), "getWord() should return 'Hello'");
    }

    /**
     * Tests the getWord method.
     * Verifies that the correct word is returned from the Word object.
     */
    @Test
    void testGetWord() {
        Word word = new Word("World");
        assertEquals("World", word.getWord(), "getWord() should return 'World'");
    }

    /**
     * Tests the toLowerCase method.
     * Verifies that the word is converted to lower case correctly.
     */
    @Test
    void testToLowerCase() {
        Word word = new Word("Hello");
        Word lowerCaseWord = word.toLowerCase();
        assertEquals("hello", lowerCaseWord.getWord(), "toLowerCase() should return 'hello'");
    }

    /**
     * Tests the equalsIgnoreCase method.
     * Verifies that words are considered equal ignoring case differences.
     */
    @Test
    void testEqualsIgnoreCase() {
        Word word1 = new Word("Hello");
        Word word2 = new Word("hello");
        Word word3 = new Word("world");

        assertTrue(word1.equalsIgnoreCase(word2), "Words should be equal ignoring case");
        assertFalse(word1.equalsIgnoreCase(word3), "Different words should not be equal ignoring case");
        assertFalse(word1.equalsIgnoreCase(null), "Should return false for null comparison");
    }

    /**
     * Tests the equals method.
     * Verifies that words are compared correctly, considering case.
     */
    @Test
    void testEquals() {
        Word word1 = new Word("Test");
        Word word2 = new Word("test");
        Word word3 = new Word("TEST");
        Word word4 = new Word("Example");

        assertTrue(word1.equals(word2), "Words should be equal ignoring case");
        assertTrue(word1.equals(word3), "Words should be equal ignoring case");
        assertFalse(word1.equals(word4), "Different words should not be equal");
        assertFalse(word1.equals(null), "Should return false for null comparison");
        assertFalse(word1.equals("Not a word"), "Should return false for different types");
    }

    /**
     * Tests the hashCode method.
     * Verifies that hash codes are equal for words ignoring case and different for different words.
     */
    @Test
    void testHashCode() {
        Word word1 = new Word("Hello");
        Word word2 = new Word("hello");
        Word word3 = new Word("World");

        assertEquals(word1.hashCode(), word2.hashCode(), "Hash codes should be equal for words ignoring case");
        assertNotEquals(word1.hashCode(), word3.hashCode(), "Hash codes should not be equal for different words");
    }

    /**
     * Tests the toString method.
     * Verifies that the correct string representation of the word is returned.
     */
    @Test
    void testToString() {
        Word word = new Word("Java");
        assertEquals("Java", word.toString(), "toString() should return 'Java'");
    }
}
