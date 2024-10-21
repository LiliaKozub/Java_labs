package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            menu();
        } catch (Exception e) {
            System.err.println("An error occured: " + e.getMessage());
        }
    }

    public static void menu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = null;
        StringBuilder[] wordsArray = null;
        boolean loop = true;

        while (loop) {
            System.out.println("Select an option:");
            System.out.println("1. Use a prepared example");
            System.out.println("2. Enter your text and word array");
            System.out.println("3. Exit the program");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    text = new StringBuilder("Java is a popular programming language. Java can be used for web development, mobile apps, and more. Programming in Java is powerful.");

                    wordsArray = new StringBuilder[]{
                            new StringBuilder("Java"),
                            new StringBuilder("programming"),
                            new StringBuilder("used"),
                            new StringBuilder("mobile")
                    };

                    UserInput.processTextAndWords(text, wordsArray);
                    SentenceWordCounter.countWordOccurrencesInSentences(wordsArray, text);
                    break;
                case "2":
                    text = UserInput.getTextInput(scanner);
                    wordsArray = UserInput.getWordsInput(scanner);
                    SentenceWordCounter.countWordOccurrencesInSentences(wordsArray, text);
                    break;
                case "3":
                    System.out.println("Exit the program...");
                    scanner.close();
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong input. Please try again.");
                    continue;
            }
        }

        scanner.close();
    }
}
