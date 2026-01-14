public class Warrior {
    // ENCAPSULATION - Different access modifiers
    private String name;              // PRIVATE - only accessible within this class
    private int health;               // PRIVATE
    private int maxHealth;            // PRIVATE
    protected int armor;              // PROTECTED - accessible in subclasses
    public int level;                 // PUBLIC - accessible everywhere

    // STATIC attributes - shared by all Warrior objects
    private static int totalWarriors = 0;
    private static final int HEALTH_PER_LEVEL = 20; // STATIC FINAL - constant

    // Constructor
    public Warrior(String name) {
        this.name = name;
        this.health = 100;
        this.maxHealth = 100;
        this.armor = 20;
        this.level = 1;
        totalWarriors++; // Increment static counter
    }

    // GETTER methods - provide controlled access to private attributes
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getArmor() {
        return armor;
    }

    public int getLevel() {
        return level;
    }

    // SETTER for armor with validation
    public void setArmor(int armor) {
        if (armor >= 0 && armor <= 50) {
            this.armor = armor;
            System.out.println(name + "'s armor set to " + armor);
        } else {
            System.out.println("Error: Armor must be between 0 and 50!");
        }
    }

    // SETTER for health with validation
    public void setHealth(int health) {
        if (health > maxHealth) {
            this.health = maxHealth;
        } else if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    // SETTER for name
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: Name cannot be empty!");
        }
    }

    // METHOD OVERLOADING - Same method name, different parameters

    // Attack version 1: No parameters
    public int attack() {
        return 15;
    }

    // Attack version 2: With bonus damage parameter
    public int attack(int bonusDamage) {
        return 15 + bonusDamage;
    }

    // Attack version 3: With weapon type parameter
    public int attack(String weaponType) {
        if (weaponType.equals("sword")) {
            return 20;
        } else if (weaponType.equals("axe")) {
            return 25;
        } else if (weaponType.equals("spear")) {
            return 18;
        } else {
            return 15;
        }
    }

    // Attack version 4: With both parameters
    public int attack(String weaponType, int bonusDamage) {
        int baseDamage = attack(weaponType); // Call overloaded method
        return baseDamage + bonusDamage;
    }

    // Method to take damage (uses private attribute armor)
    public void takeDamage(int damage) {
        int blocked = armor / 2;
        int actualDamage = damage - blocked;
        if (actualDamage < 1) {
            actualDamage = 1;
        }

        health -= actualDamage;
        if (health < 0) health = 0;

        System.out.println(name + " takes " + actualDamage + " damage! (Blocked " + blocked + " with armor)");
    }

    // Method to level up (uses STATIC FINAL constant)
    public void levelUp() {
        level++;
        maxHealth += HEALTH_PER_LEVEL; // Use static final constant
        health = maxHealth;
        System.out.println(name + " leveled up to level " + level + "!");
        System.out.println("Max health increased by " + HEALTH_PER_LEVEL + " to " + maxHealth);
    }

    // STATIC method - can be called without creating an object
    public static int getTotalWarriors() {
        return totalWarriors;
    }

    // STATIC method - compare two warriors
    public static Warrior compareWarriors(Warrior w1, Warrior w2) {
        System.out.println("Comparing warriors:");
        System.out.println("  " + w1.getName() + " - Level: " + w1.getLevel() + ", HP: " + w1.getHealth());
        System.out.println("  " + w2.getName() + " - Level: " + w2.getLevel() + ", HP: " + w2.getHealth());

        if (w1.getLevel() > w2.getLevel()) {
            return w1;
        } else if (w2.getLevel() > w1.getLevel()) {
            return w2;
        } else {
            // Same level, compare health
            if (w1.getHealth() >= w2.getHealth()) {
                return w1;
            } else {
                return w2;
            }
        }
    }

    // STATIC method - get health per level constant
    public static int getHealthPerLevel() {
        return HEALTH_PER_LEVEL;
    }

    public void displayInfo() {
        System.out.println("Warrior: " + name + " | Level: " + level +
                " | HP: " + health + "/" + maxHealth +
                " | Armor: " + armor);
    }
}