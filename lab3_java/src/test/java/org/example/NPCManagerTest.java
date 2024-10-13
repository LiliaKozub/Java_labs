package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The NPCManagerTest class contains unit tests for the NPCManager class.
 * It tests the sorting and searching functionality, as well as the creation of NPCs.
 * JUnit 5 is used to write and run the tests.
 */
class NPCManagerTest {

    private NPCManager npcManager;
    private NPC[] npcs;

    /**
     * This method runs before each test to initialize the NPCManager and set up
     * a list of NPC objects for testing.
     */
    @BeforeEach
    void setUp() {
        npcManager = new NPCManager(null);
        npcs = new NPC[]{
                new NPC("Archer", 30, 150, 300, "Scout", "Green"),
                new NPC("Mage", 25, 200, 250, "Sorcerer", "Blue"),
                new NPC("Warrior", 40, 250, 500, "Knight", "Red"),
                new NPC("Thief", 28, 180, 320, "Rogue", "Black"),
                new NPC("Healer", 35, 220, 400, "Cleric", "White"),
                new NPC("Sorceress", 25, 200, 300, "Sorcerer", "Blue"), // Duplicate role
                new NPC("Guardian", 45, 300, 600, "Defender", "Yellow"),
                new NPC("Assassin", 32, 210, 450, "Shadow", "Purple"),
                new NPC("Berserker", 38, 240, 550, "Fighter", "Red"), // Duplicate faction
                new NPC("Druid", 30, 150, 300, "Nature", "Green") // Duplicate level and values
        };
    }

    /**
     * Tests sorting of NPCs by their name and level. It ensures that after sorting,
     * the NPC array is ordered correctly by name in ascending order.
     */
    @Test
    void testSortNPCsByNameAndLevel() {
        String[] sortingFields = {"name", "level"};
        npcManager.sortNPCs(npcs, sortingFields);

        // Validate sorted NPCs by name and level
        assertEquals("Archer", npcs[0].getName());
        assertEquals("Assassin", npcs[1].getName());
        assertEquals("Berserker", npcs[2].getName());
        assertEquals("Druid", npcs[3].getName());
        assertEquals("Guardian", npcs[4].getName());
        assertEquals("Healer", npcs[5].getName());
        assertEquals("Mage", npcs[6].getName());
        assertEquals("Sorceress", npcs[7].getName());
        assertEquals("Thief", npcs[8].getName());
        assertEquals("Warrior", npcs[9].getName());
    }

    /**
     * Tests sorting of NPCs by their role and agility. It ensures that after sorting,
     * the NPC array is ordered correctly by role in ascending order and agility.
     */
    @Test
    void testSortNPCsByRoleandAgility() {
        String[] sortingFields = {"role", "agility"};
        npcManager.sortNPCs(npcs, sortingFields);

        // Validate sorted NPCs by role and agility
        assertEquals("Healer", npcs[0].getName());
        assertEquals("Guardian", npcs[1].getName());
        assertEquals("Berserker", npcs[2].getName());
        assertEquals("Warrior", npcs[3].getName());
        assertEquals("Druid", npcs[4].getName());
        assertEquals("Thief", npcs[5].getName());
        assertEquals("Archer", npcs[6].getName());
        assertEquals("Assassin", npcs[7].getName());
        assertEquals("Sorceress", npcs[8].getName());
        assertEquals("Mage", npcs[9].getName());
    }

    /**
     * Tests finding an identical NPC in the list. It ensures that the method
     * can correctly find an NPC with matching properties.
     */
    @Test
    void testFindIdenticalNPC() {
        NPC targetNPC = new NPC("Mage", 25, 200, 250, "Sorcerer", "Blue");
        NPC foundNPC = npcManager.findIdenticalNPC(npcs, targetNPC);

        assertNotNull(foundNPC);
        assertEquals("Mage", foundNPC.getName());
    }

    /**
     * Tests finding an identical NPC when no match exists. It ensures that the method
     * returns null if no identical NPC is found.
     */
    @Test
    void testFindIdenticalNPCNotFound() {
        NPC targetNPC = new NPC("Unknown", 50, 300, 500, "None", "None");
        NPC foundNPC = npcManager.findIdenticalNPC(npcs, targetNPC);

        assertNull(foundNPC);
    }

    /**
     * Tests the creation of a single NPC. It ensures that the NPC is created
     * with the correct properties.
     */
    @Test
    void testCreateSingleNPC() {
        NPC createdNPC = new NPC("TestNPC", 10, 100, 50, "TestRole", "TestFaction");

        assertEquals("TestNPC", createdNPC.getName());
        assertEquals(10, createdNPC.getLevel());
        assertEquals(100, createdNPC.getHealth());
        assertEquals(50, createdNPC.getAgility());
        assertEquals("TestRole", createdNPC.getRole());
        assertEquals("TestFaction", createdNPC.getFaction());
    }
}