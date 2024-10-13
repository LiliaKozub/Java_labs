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
            System.out.println("Введіть масив слів (через кому):");
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

    public static void validateTextInput(String inputText) throws IllegalArgumentException {
        if (inputText.isEmpty())
            throw new IllegalArgumentException("Error: Text cannot be empty. Try again");

        if (inputText.charAt(inputText.length() - 1) != '.')
            throw new IllegalArgumentException("Error: The text should end with a period. Try again");
    }

    public static void validateWordsInput(String inputWords) throws IllegalArgumentException {
        if (inputWords.isEmpty())
            throw new IllegalArgumentException("Error: array of words must not be empty. Try again");
    }
}
