package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class SentenceWordCounterTest {
    private StringBuilder[] words;
    private StringBuilder text;

    @BeforeEach
    public void setUp() {
        text = new StringBuilder("The quick brown fox jumps over the lazy dog. Java is widely used in programming. Mobile devices are essential for communication.");
        words = new StringBuilder[] {
                new StringBuilder("quick"),
                new StringBuilder("Java"),
                new StringBuilder("used"),
                new StringBuilder("Mobile")
        };
    }


    @Test
    public void testSplitTextIntoSentences() {
        StringBuilder[] sentences = SentenceWordCounter.splitTextIntoSentences(text);
        assertEquals(3, sentences.length);
        assertEquals("The quick brown fox jumps over the lazy dog", sentences[0].toString().trim());
        assertEquals("Java is widely used in programming", sentences[1].toString().trim());
        assertEquals("Mobile devices are essential for communication", sentences[2].toString().trim());
    }

    @Test
    public void testInitializeWordCountMap() {
        Map<StringBuilder, Integer> wordCountMap = SentenceWordCounter.initializeWordCountMap(words);
        for (StringBuilder word : words) {
            assertEquals(0, wordCountMap.get(word));
        }
    }

    @Test
    public void testContainsIgnoreCase() {
        StringBuilder sentence = new StringBuilder("The quick brown fox jumps over the lazy dog.");
        StringBuilder word1 = new StringBuilder("quick");
        StringBuilder word2 = new StringBuilder("cat");

        assertTrue(SentenceWordCounter.containsIgnoreCase(sentence, word1));
        assertFalse(SentenceWordCounter.containsIgnoreCase(sentence, word2));
    }

}