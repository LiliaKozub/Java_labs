package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

/**
 * This class manages the creation, display, sorting, and searching of NPC (Non-Playable Character) objects.
 * It provides functionalities to create custom NPCs, retrieve default NPCs, sort them by specified fields,
 * and search for identical NPCs in an array.
 */
public class NPCManager {
    private final Scanner scanner;

    /**
     * Constructs an NPCManager with the provided Scanner object for user input.
     *
     * @param scanner the Scanner object used for reading input from the user
     */
    public NPCManager(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Creates an array of custom NPCs based on user input.
     * The user specifies how many NPCs to create, and inputs details for each NPC.
     *
     * @return an array of custom NPC objects created by the user
     */
    public NPC[] createCustomNPCs() {
        int numNPCs = InputHandler.getValidInteger("How many NPCs do you want to create?", 1, Integer.MAX_VALUE, scanner);
        NPC[] npcs = new NPC[numNPCs];

        for (int i = 0; i < numNPCs; i++) {
            npcs[i] = createSingleNPC(i + 1, numNPCs);
        }
        return npcs;
    }

    /**
     * Returns a predefined array of default NPCs.
     *
     * @return an array of predefined NPC objects
     */
    public NPC[] getDefaultNPCs() {
        return new NPC[]{
                new NPC("Warrior", 10, 150, 400, "Tank", "Alliance"),
                new NPC("Mage", 8, 90, 500, "Damage Dealer", "Horde"),
                new NPC("Priest", 12, 70, 350, "Healer", "Alliance"),
                new NPC("Rogue", 9, 100, 800, "Damage Dealer", "Horde"),
                new NPC("Paladin", 11, 120, 600, "Tank", "Alliance")
        };
    }

    /**
     * Creates a single NPC by asking the user for input for each attribute of the NPC.
     *
     * @param npcNumber the index number of the NPC being created (for user display)
     * @param numNPCs   the total number of NPCs being created
     * @return the created NPC object based on user input
     */
    public NPC createSingleNPC(int npcNumber, int numNPCs) {
        if(numNPCs > 1){
            System.out.println("Enter data for NPC #" + npcNumber);
        }
        String name = InputHandler.getValidString("Name (letters and spaces only):", scanner);
        int level = InputHandler.getValidInteger("Level (positive integer):", 1, Integer.MAX_VALUE, scanner);
        int healthPoints = InputHandler.getValidInteger("Health Points (positive integer):", 1, Integer.MAX_VALUE, scanner);
        int agility = InputHandler.getValidInteger("Agility (positive integer):", 1, Integer.MAX_VALUE, scanner);
        String role = InputHandler.getValidString("Role (letters and spaces only):", scanner);
        String faction = InputHandler.getValidString("Faction (letters and spaces only):", scanner);

        return new NPC(name, level, healthPoints, agility, role, faction);
    }

    /**
     * Displays the details of an array of NPCs to the console.
     *
     * @param npcs the array of NPCs to display
     */
    public void displayNPCs(NPC[] npcs) {
        System.out.println("\nList of NPCs:");
        for (NPC npc : npcs) {
            System.out.println(npc);
        }
    }

    /**
     * Sorts the array of NPCs based on the specified sorting fields.
     * The first field is sorted in ascending order, and the second field is sorted in descending order.
     *
     * @param npcs          the array of NPCs to be sorted
     * @param sortingFields an array containing two field names by which the NPCs will be sorted
     *                      (e.g., "level", "agility")
     * @throws IllegalArgumentException if an invalid sorting field is provided
     */
    public void sortNPCs(NPC[] npcs, String[] sortingFields) {
        Comparator<NPC> primaryComparator = getComparator(sortingFields[0]);
        Comparator<NPC> secondaryComparator = getComparator(sortingFields[1]).reversed(); // Сортування за другим полем у порядку спадання
        Arrays.sort(npcs, primaryComparator.thenComparing(secondaryComparator));
    }

    /**
     * Returns a comparator for sorting based on the specified field.
     * Supported fields are "name", "level", "healthPoints", "agility", "role", and "faction".
     *
     * @param field the name of the field to sort by
     * @return a Comparator object for sorting NPCs by the specified field
     * @throws IllegalArgumentException if an invalid field name is provided
     */
    private Comparator<NPC> getComparator(String field) {
        switch (field.toLowerCase()) {
            case "name":
                return Comparator.comparing(NPC::getName, String.CASE_INSENSITIVE_ORDER); // Case-insensitive порівняння
            case "level":
                return Comparator.comparingInt(NPC::getLevel);
            case "healthpoints":
                return Comparator.comparingInt(NPC::getHealth);
            case "agility":
                return Comparator.comparingInt(NPC::getAgility);
            case "role":
                return Comparator.comparing(NPC::getRole, String.CASE_INSENSITIVE_ORDER);
            case "faction":
                return Comparator.comparing(NPC::getFaction, String.CASE_INSENSITIVE_ORDER);
            default:
                throw new IllegalArgumentException("Invalid sorting field: " + field);
        }
    }

    /**
     * Finds and returns the first NPC in the array that is identical to the target NPC.
     *
     * @param npcs      the array of NPCs to search in
     * @param targetNPC the NPC to compare with each NPC in the array
     * @return the NPC in the array that is identical to the target NPC, or null if no match is found
     */
    public NPC findIdenticalNPC(NPC[] npcs, NPC targetNPC) {
        for (NPC npc : npcs) {
            if (npc.equals(targetNPC)) {
                return npc;
            }
        }
        return null;
    }
}