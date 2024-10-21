package org.example;

import java.util.Arrays;

/**
 * The {@code Sentence} class represents a sentence composed of various elements,
 * such as words and punctuation marks.
 * <p>
 * This class allows for the creation of a sentence from a given string and provides
 * methods to manage the sentence elements, including adding elements, resizing the
 * underlying storage, and converting the sentence to a string representation.
 * </p>
 *
 * @param <T> the type of elements that the sentence can contain, extending {@link SentenceElement}
 * @author Liliia Kozub
 * @version 1.0
 * @since 2024-10-19
 */
public class Sentence<T extends SentenceElement> {
    /**
     * An array of elements in the sentence, which can be words or punctuation marks.
     */
    private T[] elements;

    /**
     * The current number of elements in the sentence.
     */
    private int size;

    /**
     * Constructs a {@code Sentence} object from a given string.
     * <p>
     * The input string is split into words, and each word is processed to create
     * {@link Word} objects. Punctuation marks are identified and stored as
     * {@link Punctuation} objects.
     * </p>
     *
     * @param sentence the input string representing the sentence
     */
    @SuppressWarnings("unchecked")
    public Sentence(String sentence) {
        elements = (T[]) new SentenceElement[10];
        size = 0;

        String[] wordArray = sentence.split("\\s+");
        for (String wordStr : wordArray) {
            String cleanWord = wordStr.replaceAll("[.:;,!?]", "");
            addElement((T) new Word(cleanWord));

            for (char c : wordStr.toCharArray()) {
                if (isPunctuation(c)) {
                    addElement((T) new Punctuation(c));
                }
            }
        }
    }

    /**
     * Checks if a character is a punctuation mark.
     *
     * @param c the character to check
     * @return {@code true} if the character is a punctuation mark;
     *         {@code false} otherwise
     */
    private boolean isPunctuation(char c) {
        return c == '.' || c == ',' || c == ':' || c == ';' || c == '!' || c == '?';
    }

    /**
     * Adds an element to the sentence.
     * <p>
     * If the underlying array is full, it is resized to accommodate additional elements.
     * </p>
     *
     * @param element the element to be added to the sentence
     */
    void addElement(T element) {
        if (size == elements.length) {
            resizeArray();
        }
        elements[size++] = element;
    }

    /**
     * Resizes the underlying array to double its current size.
     * <p>
     * This method is called when the array is full and needs to be expanded.
     * </p>
     */
    @SuppressWarnings("unchecked")
    private void resizeArray() {
        T[] newArray = (T[]) new SentenceElement[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }

    /**
     * Returns an array containing the elements of the sentence.
     *
     * @return an array of elements in the sentence
     */
    public T[] getElements() {
        return Arrays.copyOf(elements, size);
    }

    /**
     * Returns a string representation of the sentence without punctuation.
     *
     * @return a string representing the sentence
     */
    @Override
    public String toString() {
        return toStringWithPunctuation(true);
    }

    /**
     * Returns a string representation of the sentence.
     * <p>
     * If {@code addPunctuation} is {@code true}, a punctuation mark is added
     * at the end of the sentence if it doesn't already end with one.
     * </p>
     *
     * @param addPunctuation whether to add a punctuation mark at the end of the sentence
     * @return a string representing the sentence
     */
    public String toStringWithPunctuation(boolean addPunctuation) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            T element = elements[i];

            if (element instanceof Word) {
                if (sb.length() > 0 && !(elements[i - 1] instanceof Punctuation)) {
                    sb.append(" ");
                }
            }
            sb.append(element);

            if (element instanceof Punctuation && i < size - 1 && elements[i + 1] instanceof Word) {
                sb.append(" ");
            }
        }

        if (addPunctuation) {
            String result = sb.toString().trim();
            if (!result.endsWith(".") && !result.endsWith("!") && !result.endsWith("?")) {
                result += ".";
            }
            return result;
        }

        return sb.toString().trim();
    }
}
