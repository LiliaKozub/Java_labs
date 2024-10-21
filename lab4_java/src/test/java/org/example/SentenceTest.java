package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@code Sentence} class.
 * This class contains test cases to verify the functionality of the {@code Sentence} class methods.
 * It uses JUnit 5 for testing.
 *
 * @author Liliia Kozub
 * @version 1.0
 * @since 2024-10-19
 */
class SentenceTest {

    /**
     * Tests the creation of a {@code Sentence} object.
     * Verifies that the sentence is created successfully and the number of elements is correct.
     * It also checks the types and values of the first few elements in the sentence.
     */
    @Test
    void testSentenceCreation() {
        Sentence<SentenceElement> sentence = new Sentence<>("Hello, world! This is a test.");
        assertNotNull(sentence, "Sentence should be created successfully");

        SentenceElement[] elements = sentence.getElements();
        assertEquals(9, elements.length, "There should be 9 elements in the sentence");

        assertTrue(elements[0] instanceof Word, "First element should be a Word");
        assertEquals("Hello", ((Word) elements[0]).getWord(), "First word should be 'Hello'");

        assertTrue(elements[1] instanceof Punctuation, "Second element should be a Punctuation");
        assertEquals(',', ((Punctuation) elements[1]).getCharacter(), "Second punctuation should be ','");

        assertTrue(elements[4] instanceof Word, "Third element should be a Word");
        assertEquals("This", ((Word) elements[4]).getWord(), "Third word should be 'This'");
    }

    /**
     * Tests the {@code getElements} method of the {@code Sentence} class.
     * Verifies that the method returns the correct number of elements in the sentence.
     */
    @Test
    void testGetElements() {
        Sentence<SentenceElement> sentence = new Sentence<>("One, two, three.");
        SentenceElement[] elements = sentence.getElements();
        assertEquals(6, elements.length, "There should be 6 elements in the sentence");
    }

    /**
     * Tests the {@code toString} method of the {@code Sentence} class.
     * Verifies that the method returns the correct string representation of the sentence.
     */
    @Test
    void testToString() {
        Sentence<SentenceElement> sentence = new Sentence<>("Test sentence.");
        assertEquals("Test sentence.", sentence.toString(), "toString() should return 'Test sentence.'");
    }

    /**
     * Tests the {@code toStringWithPunctuation} method of the {@code Sentence} class.
     * Verifies that the method returns the correct string representation of the sentence with punctuation.
     */
    @Test
    void testToStringWithPunctuation() {
        Sentence<SentenceElement> sentence = new Sentence<>("Hello! How are you doing today? I hope you're well; it's a beautiful day, isn't it?");
        assertEquals("Hello! How are you doing today? I hope you're well; it's a beautiful day, isn't it?",
                sentence.toStringWithPunctuation(false),
                "toStringWithPunctuation should return the correct sentence with punctuation");
    }

    /**
     * Tests the resizing of the internal array when adding elements.
     * Verifies that the array size increases correctly when more elements are added beyond the initial capacity.
     */
    @Test
    void testResizeArray() {
        Sentence<SentenceElement> sentence = new Sentence<>("Short sentence");
        for (int i = 0; i < 20; i++) {
            sentence.addElement(new Word("word" + i));
        }
        assertEquals(22, sentence.getElements().length, "Array should resize correctly when adding elements");
    }
}
