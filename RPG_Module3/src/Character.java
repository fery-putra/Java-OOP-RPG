// ============================================================================
// MODULE 3 VERSION - Character.java (BASE CLASS)
// ============================================================================
// ⚠️ IMPORTANT: This file is specific to MODULE 3
//
// DO NOT mix this with Character.java from Module 5!
// Each module has its own version designed for specific learning goals.
//
// Module 3 Focus: Inheritance, Constructor, Method Overriding
// ============================================================================

import java.util.Scanner;

/**
 * Character class - MODULE 3 VERSION (BASE/PARENT CLASS)
 *
 * This is the PARENT class that Warrior, Mage, and Archer will INHERIT from.
 *
 * Key concepts demonstrated:
 * - CONSTRUCTOR with parameters
 * - CONSTRUCTOR OVERLOADING (two constructors)
 * - Protected methods that children can use
 * - Methods that children will OVERRIDE
 *
 * Think of this as the "general blueprint" for all characters.
 * Specific character types (Warrior, Mage, Archer) will extend this
 * and add their own unique features.
 */
public class Character {
    private String name;
    private int health;
    private int maxHealth;

    // Constructor with name and maxHealth
    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        System.out.println("Character constructor called for: " + name);
    }

    // Constructor Overloading - with only name
    public Character(String name) {
        this(name, 100); // Call other constructor using this()
        System.out.println("Default maxHealth set to 100");
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    protected void setHealth(int health) {
        this.health = Math.max(0, Math.min(health, maxHealth));
    }

    // Base attack method
    public int attack() {
        return 10;
    }

    // Method Overloading - attack with target
    public void attack(Character target) {
        int damage = this.attack();
        target.takeDamage(damage);
        System.out.println(name + " attacks " + target.getName() + " for " + damage + " damage!");
    }

    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
        System.out.println(name + " takes " + damage + " damage! HP: " + health + "/" + maxHealth);
    }

    public void displayInfo() {
        System.out.println(name + " | HP: " + health + "/" + maxHealth);
    }

    public boolean isAlive() {
        return health > 0;
    }
}



