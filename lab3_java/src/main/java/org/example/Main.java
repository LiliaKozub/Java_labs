package org.example;

import java.util.Scanner;


/**
 * The Main class serves as the entry point to the NPC management program.
 * It allows the user to create, sort, and search for NPCs (Non-Playable Characters)
 * by interacting through a console-based interface.
 */
public class Main {

    /**
     * The main method that starts the program execution.
     * It calls the run() method to manage NPCs based on user input.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        run();
    }

    /**
     * The run method is responsible for the main loop of the program, where the user can:
     * 1. Choose between manually creating NPCs or using a default set.
     * 2. Display the NPCs before and after sorting them by two fields chosen by the user.
     * 3. Find an identical NPC by entering the details of an NPC.
     * 4. Decide whether to continue using the program or exit.
     */
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        NPCManager npcManager = new NPCManager(scanner);

        boolean keepRunning = true; // Controls the main loop of the program
        while (keepRunning) {
            // Step 1: User selects how to create NPCs
            int choice = InputHandler.getUserChoice(scanner);
            NPC[] npcs = (choice == 1) ? npcManager.createCustomNPCs() : npcManager.getDefaultNPCs();

            // Step 2: Display NPCs before sorting
            npcManager.displayNPCs(npcs);

            // Step 3: User selects two fields to sort by
            String[] sortingFields = InputHandler.getSortingFields(scanner);

            // Step 4: Sort the NPCs based on the selected fields
            npcManager.sortNPCs(npcs, sortingFields);

            // Step 5: Display NPCs after sorting
            System.out.println("NPCs after sorting by " + sortingFields[0] + " and " + sortingFields[1] + ":");
            npcManager.displayNPCs(npcs);

            // Step 6: Prompt the user to enter details for finding an identical NPC
            System.out.println("\nEnter details of the NPC you want to find:");
            NPC targetNPC = npcManager.createSingleNPC(0, 1);

            // Step 7: Search for an identical NPC
            NPC foundNPC = npcManager.findIdenticalNPC(npcs, targetNPC);
            if (foundNPC != null) {
                System.out.println("\nIdentical NPC found: " + foundNPC);
            } else {
                System.out.println("\nNo identical NPC found.");
            }

            // Step 8: Ask the user if they want to continue or exit the program
            keepRunning = InputHandler.askToContinue(scanner);
        }
    }
}