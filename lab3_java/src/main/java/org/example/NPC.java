package org.example;

import java.util.Objects;

/**
 * This class represents a Non-Playable Character (NPC) in a game.
 * Each NPC has a name, level, health points, agility, role, and faction.
 */
public class NPC {
    private String name;
    private int level;
    private int health;
    private int agility;
    private String role;
    private String faction;

    /**
     * Constructs a new NPC with the specified attributes.
     *
     * @param name    the name of the NPC
     * @param level   the level of the NPC
     * @param health  the health points of the NPC
     * @param agility the agility points of the NPC
     * @param role    the role of the NPC in the game (e.g., warrior, mage)
     * @param faction the faction to which the NPC belongs (e.g., alliance, horde)
     */
    public NPC(String name, int level, int health, int agility, String role, String faction) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.agility = agility;
        this.role = role;
        this.faction = faction;
    }

    /**
     * Returns the name of the NPC.
     *
     * @return the name of the NPC
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the level of the NPC.
     *
     * @return the level of the NPC
     */
    public int getLevel() {
        return level;
    }

    /**
     * Returns the health points of the NPC.
     *
     * @return the health points of the NPC
     */
    public int getHealth() {
        return health;
    }

    /**
     * Returns the agility points of the NPC.
     *
     * @return the agility points of the NPC
     */
    public int getAgility() {
        return agility;
    }

    /**
     * Returns the role of the NPC in the game.
     *
     * @return the role of the NPC
     */
    public String getRole() {
        return role;
    }

    /**
     * Returns the faction to which the NPC belongs.
     *
     * @return the faction of the NPC
     */
    public String getFaction() {
        return faction;
    }

    /**
     * Compares this NPC with the specified object for equality.
     * The comparison is based on the name, level, health, agility, role, and faction.
     *
     * @param o the object to compare this NPC with
     * @return true if the specified object is equal to this NPC, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NPC npc = (NPC) o;
        return level == npc.level && health == npc.health && agility == npc.agility &&
                name.equals(npc.name) && role.equals(npc.role) && faction.equals(npc.faction);
    }

    /**
     * Returns a hash code value for this NPC.
     * The hash code is generated based on the NPC's name, level, health, agility, role, and faction.
     *
     * @return a hash code value for this NPC
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, level, health, agility, role, faction);
    }

    /**
     * Returns a string representation of this NPC, including all its attributes.
     *
     * @return a string representation of this NPC
     */
    @Override
    public String toString() {
        return "NPC{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", health=" + health +
                ", agility=" + agility +
                ", role='" + role + '\'' +
                ", faction='" + faction + '\'' +
                '}';
    }
}