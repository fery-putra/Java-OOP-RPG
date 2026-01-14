
// Inheritance, Constructor, Overriding and Overloading

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


