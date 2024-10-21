package org.example;

import java.util.Scanner;

/**
 * The {@code Main} class serves as the entry point for the application.
 * It provides a menu-driven interface for the user to either use a prepared
 * example or enter their own text and word array. It also handles exceptions
 * that may occur during execution.
 *
 * <p>
 * Example usage:
 * <pre>
 *     public static void main(String[] args) {
 *         Main.main(args);
 *     }
 * </pre>
 *
 *
 * @author Liliia Kozub
 * @version 1.0
 * @since 2024-10-19
 */
public class Main {
    /**
     * The main method that starts the application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            menu();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Displays the menu and handles user input to navigate through the application.
     *
     * @throws Exception if an error occurs during user input handling
     */
    public static void menu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        Word[] wordsArray;
        boolean loop = true;

        while (loop) {
            System.out.println("Select an option:");
            System.out.println("1. Use a prepared example");
            System.out.println("2. Enter your text and word array");
            System.out.println("3. Exit the program");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Text text = new Text("Java is a popular programming language. " +
                            "Java can be used for web development, mobile apps, and more. " +
                            "Programming in Java is powerful.");

                    wordsArray = new Word[]{
                            new Word("Java "),
                            new Word("programming"),
                            new Word("used"),
                            new Word("mobile")
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
