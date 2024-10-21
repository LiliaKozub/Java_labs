package org.example;

import java.util.Scanner;

public class UserInput {
    public static StringBuilder getTextInput(Scanner scanner) throws Exception {
        StringBuilder text = null;
        while (true) {
            System.out.println("Enter text:");

            String inputText = scanner.nextLine();

            try {
                validateTextInput(inputText);
                text = new StringBuilder(inputText);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return text;
    }

    public static StringBuilder[] getWordsInput(Scanner scanner) throws Exception {
        StringBuilder[] wordsArray = new StringBuilder[0];
        boolean loop = true;
        while (loop) {
            System.out.println("Enter an array of words (separated by commas):");
            String inputWords = scanner.nextLine();

            try {
                validateWordsInput(inputWords);
                String[] words = inputWords.split(",\\s*");

                wordsArray = new StringBuilder[words.length];
                for (int i = 0; i < words.length; i++) {
                    wordsArray[i] = new StringBuilder(words[i]);
                }
                loop = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return wordsArray;
    }

    public static void processTextAndWords(String preparedText, String[] wordsArray) {
        try {
            validateTextInput(preparedText);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; 
        }

        System.out.println("Prepared text:");
        System.out.println(preparedText);

        

        for (String word : wordsArray) {
            try {
                validateWordsInput(word);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }

    public static void validateTextInput(String inputText) throws IllegalArgumentException {
        if (inputText == null || inputText.trim().isEmpty())
            throw new IllegalArgumentException("Error: Text cannot be empty. Try again");

        if (lastChar != '.' && lastChar != '!' && lastChar != '?')
            throw new IllegalArgumentException("Error: The text should end with a valid punctuation mark ('.', '!', '?'). Try again");
    }

    public static void validateWordsInput(String inputWords) throws IllegalArgumentException {
        if (inputWords == null || inputWords.trim().isEmpty())
            throw new IllegalArgumentException("Error: array of words must not be empty. Try again");
    }
}
