package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@code SentenceWordCounter} class.
 * This class contains test cases to verify the functionality of the word counting methods.
 * It uses JUnit 5 for testing.
 *
 * @author Liliia Kozub
 * @version 1.0
 * @since 2024-10-19
 */
class SentenceWordCounterTest {
    private Word[] words;
    private Text text;

    /**
     * Sets up the test environment by initializing the array of words and the text to be analyzed.
     * This method is called before each test case.
     */
    @BeforeEach
    void setUp() {
        words = new Word[]{
                new Word("Java"),
                new Word("programming"),
                new Word("language"),
                new Word("powerful"),
                new Word("applications")
        };

        String preparedText = "Java is a powerful programming language. " +
                "Many applications are built with Java. " +
                "Programming in Java allows for powerful applications. " +
                "Java language is known for its versatility.";
        text = new Text(preparedText);
    }

    /**
     * Tests the initialization of the word count map.
     * Verifies that the initial count for each word in the map is zero.
     */
    @Test
    void testInitializeWordCountMap() {
        Map<Word, Integer> wordCountMap = SentenceWordCounter.initializeWordCountMap(words);

        for (Word word : words) {
            assertEquals(0, wordCountMap.get(word.toLowerCase()), "Initial count should be zero for word: " + word);
        }
    }

    /**
     * Tests the word counting in a single sentence.
     * Verifies that the count of each word in the specified sentence is accurate.
     */
    @Test
    void testCountWordsInSentence() {
        Map<Word, Integer> wordCountMap = SentenceWordCounter.initializeWordCountMap(words);
        Sentence<?> sentence = text.getSentences()[0];

        SentenceWordCounter.countWordsInSentence(sentence, words, wordCountMap);

        assertEquals(1, wordCountMap.get(new Word("Java").toLowerCase()), "Count for 'Java' should be 1.");
        assertEquals(1, wordCountMap.get(new Word("programming").toLowerCase()), "Count for 'programming' should be 1.");
        assertEquals(1, wordCountMap.get(new Word("language").toLowerCase()), "Count for 'language' should be 1.");
        assertEquals(1, wordCountMap.get(new Word("powerful").toLowerCase()), "Count for 'powerful' should be 1.");
        assertEquals(0, wordCountMap.get(new Word("applications").toLowerCase()), "Count for 'applications' should be 0.");
    }

    /**
     * Tests the counting of word occurrences in multiple sentences with console output.
     * Verifies that the output correctly reflects the number of sentences each word appears in.
     */
    @Test
    void testCountWordOccurrencesInSentencesWithConsoleOutput() {
        Word[] words = {
                new Word("Java"), new Word("programming"), new Word("language"),
                new Word("powerful"), new Word("applications")
        };

        Text text = new Text("Java is a powerful programming language. "
                + "Many applications are written in Java. "
                + "Java is widely used in enterprise applications.");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        SentenceWordCounter.countWordOccurrencesInSentences(words, text);

        System.setOut(originalOut);

        String actualOutput = outputStream.toString().trim();

        String expectedOutput =
                "Word 'Java' occurs in 3 sentences.\r\n" +
                        "Word 'programming' occurs in 1 sentences.\r\n" +
                        "Word 'language' occurs in 1 sentences.\r\n" +
                        "Word 'powerful' occurs in 1 sentences.\r\n" +
                        "Word 'applications' occurs in 2 sentences.";

        assertEquals(expectedOutput, actualOutput);
    }
}
