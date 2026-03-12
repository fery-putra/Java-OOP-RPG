// ============================================================================
// MODULE 3 VERSION - Warrior.java (CHILD CLASS)
// ============================================================================
// ⚠️ IMPORTANT: This file is specific to MODULE 3
//
// This Warrior class EXTENDS Character (inheritance)
// It's different from Module 2's Warrior!
//
// Module 3 Focus: Inheritance, super(), Method Overriding
// ============================================================================

/**
 * Warrior class - MODULE 3 VERSION (CHILD CLASS)
 *
 * This class EXTENDS (inherits from) Character.
 * It inherits all of Character's attributes and methods,
 * then adds its own unique feature: ARMOR
 *
 * Key concepts demonstrated:
 * - EXTENDS keyword (inheritance)
 * - SUPER() to call parent constructor
 * - CONSTRUCTOR OVERLOADING (3 constructors)
 * - METHOD OVERRIDING (@Override)
 * - Calling parent methods with super.methodName()
 */
class Warrior extends Character {
    private int armor;  // Warrior-specific attribute (not in parent)

    // Constructor with name - calls parent constructor
    public Warrior(String name) {
        super(name, 150); // SUPER() - calls Character's constructor
        this.armor = 25;
        System.out.println("Warrior constructor called - Armor set to 25");
    }

    // Constructor Overloading - with name and custom armor
    public Warrior(String name, int armor) {
        super(name, 150); // Call parent constructor
        this.armor = armor;
        System.out.println("Warrior constructor called - Custom armor: " + armor);
    }

    // Constructor Overloading - with name, armor, and maxHealth
    public Warrior(String name, int armor, int maxHealth) {
        super(name, maxHealth); // Call parent constructor with custom health
        this.armor = armor;
        System.out.println("Warrior constructor called - Custom armor and health");
    }

    public int getArmor() {
        return armor;
    }

    // OVERRIDING - Warriors deal more damage
    @Override
    public int attack() {
        return 20;
    }

    // OVERRIDING - Custom attack message
    @Override
    public void attack(Character target) {
        super.attack(target); // Call parent method
        System.out.println(getName() + " slashes with great force!");
    }

    // OVERRIDING - Armor reduces damage
    @Override
    public void takeDamage(int damage) {
        int blocked = armor / 2;
        int reducedDamage = Math.max(1, damage - blocked);
        System.out.println(getName() + " blocks " + blocked + " damage with armor!");
        super.takeDamage(reducedDamage); // Call parent method
    }

    // OVERRIDING - Add armor info
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method
        System.out.println("Armor: " + armor);
    }

    // New method (not overriding)
    public void shieldBash(Character target) {
        int damage = armor;
        System.out.println(getName() + " performs SHIELD BASH!");
        target.takeDamage(damage);
    }
}