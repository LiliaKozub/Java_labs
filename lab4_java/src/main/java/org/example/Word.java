package org.example;

/**
 * The {@code Word} class represents a word consisting of an array of {@link Letter} objects.
 * <p>
 * This class provides methods to retrieve the word as a string, convert it to lowercase,
 * compare it with other words case-insensitively, and generate its hash code.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     Word word = new Word("Hello");
 *     System.out.println(word);                   // Outputs 'Hello'
 *     System.out.println(word.toLowerCase());     // Outputs 'hello'
 *     System.out.println(word.equalsIgnoreCase(new Word("HELLO"))); // Outputs true
 * </pre>
 *
 * @author Liliia Kozub
 * @version 1.0
 * @since 2024-10-19
 */
public class Word implements SentenceElement {

    /**
     * Array of {@link Letter} objects representing the individual letters of the word.
     */
    private Letter[] letters;

    /**
     * Constructs a {@code Word} object by converting a string into an array of {@link Letter} objects.
     * <p>
     * Any leading or trailing spaces in the input string are trimmed.
     * </p>
     *
     * @param word the string representation of the word
     * @throws NullPointerException if the input word is {@code null}
     */
    public Word(String word) {
        word = word.trim();
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i));
        }
    }

    /**
     * Returns the word as a string by concatenating the characters of each {@link Letter} object.
     *
     * @return the string representation of the word
     */
    public String getWord() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter.getCharacter());
        }
        return sb.toString();
    }

    /**
     * Converts all the letters of the word to lowercase and returns a new {@code Word} object.
     * <p>
     * Each {@link Letter} in the word is converted to its lowercase equivalent.
     * </p>
     *
     * @return a new {@code Word} object where all letters are in lowercase
     */
    public Word toLowerCase() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter.toLowerCase());
        }
        return new Word(sb.toString());
    }

    /**
     * Compares this word with another word for equality, ignoring case considerations.
     * <p>
     * The comparison is case-insensitive, meaning that 'Word' and 'word' will be considered equal.
     * </p>
     *
     * @param otherWord the {@code Word} object to compare with
     * @return {@code true} if the words are equal, ignoring case; {@code false} otherwise
     */
    public boolean equalsIgnoreCase(Word otherWord) {
        if (otherWord == null || this.letters.length != otherWord.letters.length) {
            return false;
        }

        for (int i = 0; i < this.letters.length; i++) {
            if (this.letters[i].toLowerCase() != otherWord.letters[i].toLowerCase()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compares this word with another object for equality.
     * <p>
     * If the object is an instance of {@code Word}, the comparison is done
     * using the {@link #equalsIgnoreCase(Word)} method.
     * </p>
     *
     * @param obj the object to compare with
     * @return {@code true} if the words are equal, ignoring case; {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Word)) return false;

        Word otherWord = (Word) obj;
        return equalsIgnoreCase(otherWord);
    }

    /**
     * Returns the hash code for this word.
     * <p>
     * The hash code is calculated based on the lowercase string representation of the word.
     * </p>
     *
     * @return the hash code of the word
     */
    @Override
    public int hashCode() {
        return getWord().toLowerCase().hashCode();
    }

    /**
     * Returns the string representation of this word.
     * <p>
     * This is equivalent to calling {@link #getWord()}.
     * </p>
     *
     * @return the string representation of the word
     */
    @Override
    public String toString() {
        return getWord();
    }
}
