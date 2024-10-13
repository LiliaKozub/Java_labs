package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The InputHandler class provides utility methods to handle various types of user input validation.
 * It includes methods for getting valid string and integer inputs, user choices, sorting fields,
 * and checking if the user wants to continue the program.
 */
public class InputHandler {

    /**
     * Prompts the user to choose an option for NPC creation, ensuring valid input is provided.
     * Valid options are:
     * 1 - Enter NPC parameters manually
     * 2 - Use default NPC set
     *
     * @param scanner The Scanner object to read user input
     * @return The choice of the user (1 or 2)
     */
    public static int getUserChoice(Scanner scanner) {
        int choice = 0;
        boolean loop = true;

        while (loop) {
            try {
                System.out.println("Please enter your choice: ");
                System.out.println("1. Enter parameters for NPC yourself.");
                System.out.println("2. Use a ready set of NPCs.");
                choice = scanner.nextInt();

                if (choice != 1 && choice != 2)
                    throw new IllegalArgumentException("Error: Enter 1 or 2");
                loop = false;
            } catch (InputMismatchException e) {
                System.out.println("Error: Incorrect data type entered. Enter a number.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return choice;
    }

    /**
     * Prompts the user to enter a valid string input that consists of only letters and spaces.
     *
     * @param prompt  The message to prompt the user for input
     * @param scanner The Scanner object to read user input
     * @return A valid string input that matches the pattern (letters and spaces only)
     */
    public static String getValidString(String prompt, Scanner scanner) {
        String input;
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]+$");

        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                return input;
            } else {
                System.out.println("Error: Invalid input. Please try again.");
            }
        }
    }

    /**
     * Prompts the user to enter a valid integer within a specified range.
     *
     * @param prompt  The message to prompt the user for input
     * @param min     The minimum allowed integer value
     * @param max     The maximum allowed integer value
     * @param scanner The Scanner object to read user input
     * @return A valid integer input within the specified range
     */
    public static int getValidInteger(String prompt, int min, int max, Scanner scanner) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer
                if (value < min || value > max) {
                    System.out.println("Error: Please enter a value between " + min + " and " + max + ".");
                } else {
                    return value;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }

    /**
     * Allows the user to select two fields for sorting NPCs.
     * The available fields are:
     * - Name
     * - Level
     * - Health Points
     * - Agility
     * - Role
     * - Faction
     *
     * @param scanner The Scanner object to read user input
     * @return An array of two chosen fields for sorting
     */
    public static String[] getSortingFields(Scanner scanner) {
        String[] fields = {"name", "level", "healthPoints", "agility", "role", "faction"};
        String[] chosenFields = new String[2];

        System.out.println("\nChoose two fields to sort by:");
        for (int i = 0; i < fields.length; i++) {
            System.out.println((i + 1) + ". " + fields[i]);
        }

        chosenFields[0] = fields[getValidInteger("Enter the number for the first field: ", 1, fields.length, scanner) - 1];
        chosenFields[1] = fields[getValidInteger("Enter the number for the second field: ", 1, fields.length, scanner) - 1];

        return chosenFields;
    }

    /**
     * Prompts the user to indicate whether they want to continue the program or not.
     * Valid responses are "yes", "y", "no", or "n".
     *
     * @param scanner The Scanner object to read user input
     * @return true if the user wants to continue, false if they want to exit
     */
    public static boolean askToContinue(Scanner scanner) {
        String userInput;

        while (true) {
            System.out.println("\nDo you want to continue? (yes/no):");
            userInput = scanner.nextLine().trim().toLowerCase();

            if (userInput.equals("no") || userInput.equals("n")) {
                System.out.println("Exiting program...");
                return false;
            } else if (userInput.equals("yes") || userInput.equals("y")) {
                return true;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no':");
            }
        }
    }
}