// ============================================================================
// MODULE 1: Monster class - Another example of CLASS concept
// ============================================================================

/**
 * Monster class - Demonstrates creating a SECOND class (Module 1)
 *
 * This shows that you can have multiple classes in a program.
 * Each class represents a different type of object (Hero vs Monster).
 *
 * Compare this with Hero class - both have similar structure:
 * - Attributes (properties)
 * - Methods (behaviors)
 * But different specific details!
 */
class Monster {

    // ATTRIBUTES - Monster's properties (simpler than Hero)
    String name;      // Monster's name
    int health;       // Monster's hit points
    int damage;       // How much damage monster deals

    /**
     * Initialize monster data - similar to Hero's setHeroData()
     *
     * Notice: Same pattern as Hero class!
     * This shows consistency in OOP design.
     */
    public void setMonsterData(String name, int health, int damage) {
        this.name = name;        // 'this' differentiates attribute from parameter
        this.health = health;
        this.damage = damage;
    }

    /**
     * Display monster information - OUTPUT demonstration
     *
     * Simpler than Hero's displayInfo() - monsters have fewer attributes.
     * Shows all info on one line for cleaner battle output.
     */
    public void displayInfo() {
        // Single line output with pipe (|) separators for readability
        System.out.println("Monster: " + name + " | HP: " + health + " | Damage: " + damage);
    }

    /**
     * Monster attack - much simpler than Hero's attack()
     *
     * Monsters always deal the same damage (no mana system).
     * Returns damage value so Game class can apply it to hero.
     */
    public int attack() {
        return damage;  // Simply return the damage attribute
    }

    /**
     * Take damage - similar to Hero but simpler
     *
     * Shows CONDITION usage: if (health < 0) health = 0
     * Prevents negative health display.
     */
    public void takeDamage(int damage) {
        health -= damage;  // Reduce health

        // Ensure health never goes below 0 (prevent displaying -5 HP)
        if (health < 0) health = 0;
    }

    /**
     * Check if monster is alive - boolean return type
     *
     * Returns true/false based on condition.
     * Used in battle loop to check if fight should continue.
     */
    public boolean isAlive() {
        return health > 0;  // If health > 0, return true; else return false
    }
}