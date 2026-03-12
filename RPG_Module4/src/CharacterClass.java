// ============================================================================
// MODULE 4 VERSION - CharacterClass.java (ENUM)
// ============================================================================
// ⚠️ IMPORTANT: This file is specific to MODULE 4
//
// Module 4 Focus: ENUM with attributes and methods
// ============================================================================

import java.util.Scanner;

/**
 * CharacterClass enum - MODULE 4 VERSION
 *
 * This ENUM demonstrates:
 * - Fixed set of constants (WARRIOR, MAGE, ARCHER, PALADIN)
 * - Enums with ATTRIBUTES (baseDamage, baseHealth, description)
 * - Enums with METHODS (getters)
 * - FINAL attributes (cannot change)
 *
 * Why ENUM? It guarantees only these 4 classes exist.
 * You can't accidentally create "NINJA" or typo "WARIOR".
 */
enum CharacterClass {
    // The ONLY valid character classes (fixed, unchangeable)
    WARRIOR(20, 150, "Strong melee fighter"),
    MAGE(30, 80, "Powerful spellcaster"),
    ARCHER(15, 100, "Ranged attacker"),
    PALADIN(18, 130, "Holy knight");

    // Each enum constant has these attributes
    private final int baseDamage;      // FINAL - cannot change
    private final int baseHealth;      // FINAL - cannot change
    private final String description;  // FINAL - cannot change

    CharacterClass(int baseDamage, int baseHealth, String description) {
        this.baseDamage = baseDamage;
        this.baseHealth = baseHealth;
        this.description = description;
    }

    public int getBaseDamage() { return baseDamage; }
    public int getBaseHealth() { return baseHealth; }
    public String getDescription() { return description; }
}

// ==================== Element.java (ENUM) ====================


// ==================== Combatant.java (ABSTRACT CLASS) ====================


// ==================== Magical.java (INTERFACE) ====================


// ==================== Defensive.java (INTERFACE) ====================


// ==================== Warrior.java ====================


// ==================== Mage.java ====================


// ==================== Paladin.java ====================


// ==================== Archer.java ====================


// ==================== GameMaster.java (FINAL CLASS) ====================


// ==================== Game.java ====================


