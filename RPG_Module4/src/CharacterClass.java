// MODULE 4: COMPLETE SOLUTION - PART 1/2
// Final Variable, Static Final, Final Method, Final Class, Enum, Enum in Switch
// Abstract Class, Abstract Method, Concrete Method, Interface, Polymorphism, Upcasting, Downcasting

// ==================== CharacterClass.java (ENUM) ====================
public enum CharacterClass {
    WARRIOR(20, 150, "Strong melee fighter"),
    MAGE(30, 80, "Powerful spellcaster"),
    ARCHER(15, 100, "Ranged attacker"),
    PALADIN(18, 130, "Holy knight");

    // FINAL variables in enum (cannot be changed)
    private final int baseDamage;
    private final int baseHealth;
    private final String description;

    // Enum constructor
    CharacterClass(int baseDamage, int baseHealth, String description) {
        this.baseDamage = baseDamage;
        this.baseHealth = baseHealth;
        this.description = description;
    }

    public int getBaseDamage() { return baseDamage; }
    public int getBaseHealth() { return baseHealth; }
    public String getDescription() { return description; }
}

