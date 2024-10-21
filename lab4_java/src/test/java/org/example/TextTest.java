package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@code Text} class.
 * This class contains test cases to verify the functionality of the Text constructor
 * and its methods, including handling of sentences and formatting.
 *
 * @author Liliia Kozub
 * @version 1.0
 * @since 2024-10-19
 */
public class TextTest {

    /**
     * Tests the Text constructor with multiple sentences.
     * Verifies that the correct number of sentences is created and that each sentence is formatted correctly.
     */
    @Test
    void testConstructorWithMultipleSentences() {
        Text text = new Text("Hello world! This is a test. How are you?");
        Sentence<?>[] sentences = text.getSentences();

        assertEquals(3, sentences.length, "Should contain three sentences");
        assertEquals("Hello world!", sentences[0].toStringWithPunctuation(false));
        assertEquals("This is a test.", sentences[1].toStringWithPunctuation(false));
        assertEquals("How are you?", sentences[2].toStringWithPunctuation(false));
    }

    /**
     * Tests the Text constructor with an empty string.
     * Verifies that no sentences are created when the input text is empty.
     */
    @Test
    void testConstructorWithEmptyString() {
        Text text = new Text("");
        Sentence<?>[] sentences = text.getSentences();

        assertEquals(0, sentences.length, "Should contain zero sentences");
    }

    /**
     * Tests the Text constructor with whitespace only.
     * Verifies that no sentences are created when the input text contains only whitespace.
     */
    @Test
    void testConstructorWithWhitespaceOnly() {
        Text text = new Text("     ");
        Sentence<?>[] sentences = text.getSentences();

        assertEquals(0, sentences.length, "Should contain zero sentences");
    }

    /**
     * Tests the toString method with punctuation.
     * Verifies that the formatted text matches the expected output.
     */
    @Test
    void testToStringWithPunctuation() {
        Text text = new Text("Hello world! This is a test. How are you?");
        String expected = "Hello world! This is a test. How are you?";
        assertEquals(expected, text.toString(), "toString() should return the correct formatted text");
    }

    /**
     * Tests the toString method with no ending punctuation.
     * Verifies that a period is added at the end of the text if there's no ending punctuation.
     */
    @Test
    void testToStringWithNoEndingPunctuation() {
        Text text = new Text("Hello world! This is a test How are you");
        String expected = "Hello world! This is a test How are you.";
        assertEquals(expected, text.toString(), "toString() should add a period at the end if there's no ending punctuation");
    }

    /**
     * Tests the toString method with a single sentence.
     * Verifies that the formatted text of a single sentence is returned correctly.
     */
    @Test
    void testToStringWithSingleSentence() {
        Text text = new Text("Hello world.");
        String expected = "Hello world.";
        assertEquals(expected, text.toString(), "toString() should return the single sentence correctly");
    }
}
