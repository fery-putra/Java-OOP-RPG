abstract class Combatant {
    protected String name;
    protected int health;
    protected int maxHealth;

    // STATIC FINAL - constant shared by all combatants
    protected static final int MIN_DAMAGE = 1;
    protected static final int MAX_LEVEL = 10;

    public Combatant(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }

    protected void setHealth(int health) {
        this.health = Math.max(0, Math.min(health, maxHealth));
    }

    // ABSTRACT METHODS - must be implemented by subclasses
    public abstract int attack();
    public abstract CharacterClass getCharacterClass();

    // CONCRETE METHOD - has implementation, can be used/overridden
    public void takeDamage(int damage) {
        damage = Math.max(MIN_DAMAGE, damage); // Use static final
        health = Math.max(0, health - damage);
        System.out.println(name + " takes " + damage + " damage!");
    }

    // CONCRETE METHOD
    public boolean isAlive() {
        return health > 0;
    }

    // CONCRETE METHOD
    public void displayInfo() {
        System.out.println(name + " | HP: " + health + "/" + maxHealth +
                " | Class: " + getCharacterClass());
    }

    // FINAL METHOD - cannot be overridden by subclasses
    public final void displayStats() {
        System.out.println("=== " + name + " Stats ===");
        System.out.println("Class: " + getCharacterClass());
        System.out.println("HP: " + health + "/" + maxHealth);
        System.out.println("Base Damage: " + attack());
        System.out.println("Status: " + (isAlive() ? "Alive" : "Dead"));
    }
}