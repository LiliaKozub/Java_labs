package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code SentenceWordCounter} class provides functionality to count the occurrences
 * of specific words in a given text composed of sentences.
 * <p>
 * This class contains methods to initialize a word count map, count word occurrences in
 * sentences, and display the results. It uses the {@link Word} and {@link Text} classes
 * for its operations.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     Text text = new Text("Hello world! This is a test. How are you?");
 *     Word[] words = { new Word("Hello"), new Word("test"), new Word("world") };
 *     SentenceWordCounter.countWordOccurrencesInSentences(words, text);
 * </pre>
 *
 * @author Liliia Kozub
 * @version 1.0
 * @since 2024-10-19
 */
public class SentenceWordCounter {
    /**
     * Counts the occurrences of the specified words in the sentences of the given text.
     *
     * @param words an array of {@link Word} objects to count in the sentences
     * @param text  the {@link Text} object containing the sentences to search
     */
    public static void countWordOccurrencesInSentences(Word[] words, Text text) {
        Map<Word, Integer> wordCountMap = initializeWordCountMap(words);
        Sentence<?>[] sentences = text.getSentences();

        for (Sentence<?> sentence : sentences) {
            if (sentence != null) {
                countWordsInSentence(sentence, words, wordCountMap);
            }
        }

        displayResults(words, wordCountMap);
    }

    /**
     * Initializes a map to keep track of word occurrences.
     * The keys are the words in lowercase, and the values are initialized to 0.
     *
     * @param words an array of {@link Word} objects to initialize the count map
     * @return a map containing words and their initial counts set to 0
     */
    static Map<Word, Integer> initializeWordCountMap(Word[] words) {
        Map<Word, Integer> wordCountMap = new HashMap<>();
        for (Word word : words) {
            wordCountMap.put(word.toLowerCase(), 0);
        }
        return wordCountMap;
    }

    /**
     * Counts the occurrences of the specified words within a given sentence.
     *
     * @param sentence     the {@link Sentence} object to search for words
     * @param words        an array of {@link Word} objects to count
     * @param wordCountMap a map that tracks the occurrences of each word
     */
    static void countWordsInSentence(Sentence<?> sentence, Word[] words, Map<Word, Integer> wordCountMap) {
        for (Word word : words) {
            Word lowerCaseWord = word.toLowerCase();

            boolean wordFound = false;
            for (SentenceElement element : sentence.getElements()) {
                if (element instanceof Word && ((Word) element).toLowerCase().equals(lowerCaseWord)) {
                    wordFound = true;
                    break;
                }
            }
            if (wordFound) {
                wordCountMap.put(lowerCaseWord, wordCountMap.get(lowerCaseWord) + 1); // Increment the counter
            }
        }
    }

    /**
     * Displays the results of the word occurrences in the sentences.
     *
     * @param words       an array of {@link Word} objects that were counted
     * @param wordCountMap a map that contains the counts of each word
     */
    private static void displayResults(Word[] words, Map<Word, Integer> wordCountMap) {
        for (Word word : words) {
            Integer count = wordCountMap.get(word.toLowerCase());
            System.out.println("Word '" + word.getWord() + "' occurs in " + (count != null ? count : 0) + " sentences.");
        }
    }
}
