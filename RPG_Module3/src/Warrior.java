class Warrior extends Character {
    private int armor;

    // Constructor with name - calls parent constructor
    public Warrior(String name) {
        super(name, 150); // Call parent constructor with super()
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