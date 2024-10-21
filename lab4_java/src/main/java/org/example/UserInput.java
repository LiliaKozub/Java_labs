package org.example;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The {@code UserInput} class handles user input for text and words.
 * It provides methods to collect and validate input from the user.
 * This class interacts with the console to prompt the user for input
 * and ensures that the input meets certain validation criteria.
 *
 * <p>
 * Example usage:
 * <pre>
 *     Scanner scanner = new Scanner(System.in);
 *     Text preparedText = UserInput.getTextInput(scanner);
 *     Word[] wordsArray = UserInput.getWordsInput(scanner);
 *     UserInput.processTextAndWords(preparedText, wordsArray);
 * </pre>
 *
 * @author Liliia Kozub
 * @version 1.0
 * @since 2024-10-19
 */
public class UserInput {
    /**
     * Prompts the user to enter text and validates the input.
     *
     * @param scanner the {@link Scanner} object for reading user input
     * @return a {@link Text} object created from the user's input
     * @throws Exception if an error occurs during input processing
     */
    public static Text getTextInput(Scanner scanner) throws Exception {
        String text = null;
        while (true) {
            System.out.println("Enter text:");

            text = scanner.nextLine();

            try {
                validateTextInput(text);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return new Text(text);
    }

    /**
     * Prompts the user to enter an array of words and validates the input.
     *
     * @param scanner the {@link Scanner} object for reading user input
     * @return an array of {@link Word} objects created from the user's input
     * @throws Exception if an error occurs during input processing
     */
    public static Word[] getWordsInput(Scanner scanner) throws Exception {
        Word[] wordsArray = new Word[0];
        boolean loop = true;
        while (loop) {
            System.out.println("Enter an array of words (separated by commas):");
            String inputWords = scanner.nextLine();

            try {
                validateWordsInput(inputWords);
                String[] words = inputWords.split(",\\s*");

                wordsArray = new Word[words.length];
                for (int i = 0; i < words.length; i++) {
                    wordsArray[i] = new Word(words[i]);
                }
                loop = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return wordsArray;
    }

    /**
     * Processes the provided text and array of words, validating the text and words.
     *
     * @param preparedText the {@link Text} object to validate and display
     * @param wordsArray   an array of {@link Word} objects to validate
     */
    public static void processTextAndWords(Text preparedText, Word[] wordsArray) {
        try {
            UserInput.validateTextInput(preparedText.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; // Exit if validation fails
        }

        System.out.println("Prepared text:");
        System.out.println(preparedText);

        String[] stringArray = Arrays.stream(wordsArray)
                .map(Word::toString)
                .toArray(String[]::new);

        for (String word : stringArray) {
            try {
                UserInput.validateWordsInput(word);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }

    /**
     * Validates the input text to ensure it is not empty and ends with a valid punctuation mark.
     *
     * @param inputText the text to validate
     * @throws IllegalArgumentException if the text is empty or does not end with a valid punctuation mark
     */
    public static void validateTextInput(String inputText) throws IllegalArgumentException {
        if (inputText == null || inputText.trim().isEmpty())
            throw new IllegalArgumentException("Error: Text cannot be empty. Try again");

        char lastChar = inputText.charAt(inputText.length() - 1);
        if (lastChar != '.' && lastChar != '!' && lastChar != '?')
            throw new IllegalArgumentException("Error: The text should end with a valid punctuation mark ('.', '!', '?'). Try again");
    }

    /**
     * Validates the input words to ensure the array is not empty.
     *
     * @param inputWords the words to validate
     * @throws IllegalArgumentException if the array of words is empty
     */
    public static void validateWordsInput(String inputWords) throws IllegalArgumentException {
        if (inputWords == null || inputWords.trim().isEmpty())
            throw new IllegalArgumentException("Error: array of words must not be empty. Try again");
    }
}

