// MODULE 4: COMPLETE SOLUTION WITH USER INPUT
// Final, Enum, Abstract, Interface, Polymorphism, Casting

import java.util.Scanner;

// ==================== CharacterClass.java (ENUM) ====================
enum CharacterClass {
    WARRIOR(20, 150, "Strong melee fighter"),
    MAGE(30, 80, "Powerful spellcaster"),
    ARCHER(15, 100, "Ranged attacker"),
    PALADIN(18, 130, "Holy knight");

    private final int baseDamage;
    private final int baseHealth;
    private final String description;

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


