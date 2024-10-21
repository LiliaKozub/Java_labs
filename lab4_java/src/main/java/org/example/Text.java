package org.example;

/**
 * The {@code Text} class represents a collection of sentences parsed from a given text.
 * <p>
 * This class takes a string of text as input and splits it into individual sentences,
 * which can be accessed as an array of {@link Sentence} objects. The class also provides
 * a method to retrieve the sentences and a method to return the text representation
 * of the sentences with proper punctuation.
 * </p>
 *
 * <p>
 * The sentences are separated by punctuation marks such as '.', '!', and '?'.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * Text text = new Text("Hello world! This is a test. How are you?");
 * for (Sentence<?> sentence : text.getSentences()) {
 *     System.out.println(sentence);
 * }
 * }
 * </pre>
 *
 * @author Lilia Kozub
 * @version 1.0
 * @since 2024-10-19
 */
public class Text {
    /**
     * An array of {@link Sentence} objects representing the sentences parsed from the text.
     */
    private Sentence<?>[] sentences;

    /**
     * Constructs a {@code Text} object and parses the given text into sentences.
     * <p>
     * If the provided text is null or empty, an empty array of sentences is created.
     * </p>
     *
     * @param text the text to be parsed into sentences
     */
    @SuppressWarnings("unchecked")
    public Text(String text) {
        if (text == null || text.trim().isEmpty()) {
            sentences = new Sentence[0];
            return;
        }

        String[] sentenceArray = text.split("(?<=[.!?])\\s*");
        sentences = new Sentence[sentenceArray.length];

        for (int i = 0; i < sentenceArray.length; i++) {
            String sentenceStr = sentenceArray[i].trim();
            if (!sentenceStr.isEmpty()) {
                sentences[i] = new Sentence<>(sentenceStr);
            }
        }
    }

    /**
     * Returns an array of sentences parsed from the text.
     *
     * @return an array of {@link Sentence} objects representing the sentences in the text
     */
    public Sentence<?>[] getSentences() {
        return sentences;
    }

    /**
     * Returns a string representation of the text, which consists of all sentences
     * without punctuation at the end, but adds a period if the text does not end with
     * a punctuation mark.
     *
     * @return a string representation of the text
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            if (sentences[i] != null) {
                sb.append(sentences[i].toStringWithPunctuation(false));
                if (i < sentences.length - 1) {
                    sb.append(" ");
                }
            }
        }

        String result = sb.toString().trim();
        if (!result.endsWith(".") && !result.endsWith("!") && !result.endsWith("?")) {
            result += ".";
        }
        return result;
    }
}
