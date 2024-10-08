package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            menu();
        } catch (Exception e) {
            System.err.println("Виникла помилка: " + e.getMessage());
        }
    }

    public static void menu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = null;
        StringBuilder[] wordsArray = null;
        boolean loop = true;

        while (loop) {
            System.out.println("Виберіть опцію:");
            System.out.println("1. Використати готовий приклад");
            System.out.println("2. Ввести свій текст і масив слів");
            System.out.println("3. Вихід");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // Введені дані (готовий приклад)
                    text = new StringBuilder("Java is a popular programming language. Java can be used for web development, mobile apps, and more. Programming in Java is powerful.");

                    // Виведення тексту перед виконанням прикладу
                    System.out.println("Готовий текст:");
                    System.out.println(text);

                    // Створення масиву StringBuilder для слів
                    wordsArray = new StringBuilder[]{
                            new StringBuilder("Java"),
                            new StringBuilder("programming"),
                            new StringBuilder("used"),
                            new StringBuilder("mobile")
                    };

                    SentenceWordCounter.countWordOccurrencesInSentences(wordsArray, text);
                    break;
                case "2":
                    text = UserInput.getTextInput(scanner);
                    wordsArray = UserInput.getWordsInput(scanner);
                    SentenceWordCounter.countWordOccurrencesInSentences(wordsArray, text);
                    break;
                case "3":
                    System.out.println("Вихід з програми.");
                    scanner.close();
                    loop = false;
                    break;
                default:
                    System.out.println("Неправильний вибір. Будь ласка, спробуйте ще раз.");
                    continue;
            }
        }

        scanner.close();
    }
}