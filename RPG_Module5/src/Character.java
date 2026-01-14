class Character {
    private String name;
    private int health;
    private int maxHealth;
    private int mana;
    private int maxMana;

    public Character(String name, int maxHealth, int maxMana) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.maxMana = maxMana;
        this.mana = maxMana;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getMana() { return mana; }
    public int getMaxMana() { return maxMana; }

    public boolean isAlive() {
        return health > 0;
    }

    public void attack(Character target) throws CharacterDeadException, InvalidTargetException {
        if (!this.isAlive()) {
            throw new CharacterDeadException(name + " is dead and cannot attack!");
        }

        if (!target.isAlive()) {
            throw new InvalidTargetException(target.getName() + " is already dead!");
        }

        int damage = 15;
        target.takeDamage(damage);
        System.out.println(name + " attacks " + target.getName() + " for " + damage + " damage!");
    }

    public void castSpell(Character target, int manaCost)
            throws CharacterDeadException, InvalidTargetException, InsufficientManaException {

        if (!this.isAlive()) {
            throw new CharacterDeadException(name + " is dead!");
        }

        if (!target.isAlive()) {
            throw new InvalidTargetException(target.getName() + " is already dead!");
        }

        if (mana < manaCost) {
            throw new InsufficientManaException("Not enough mana! Need: " + manaCost + ", Have: " + mana);
        }

        mana -= manaCost;
        int damage = manaCost * 2;
        target.takeDamage(damage);
        System.out.println(name + " casts spell on " + target.getName() + " for " + damage + " damage!");
    }

    public void heal(int amount) throws CharacterDeadException {
        if (!isAlive()) {
            throw new CharacterDeadException("Cannot heal " + name + " - already dead!");
        }

        health = Math.min(maxHealth, health + amount);
        System.out.println(name + " heals for " + amount + " HP!");
    }

    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
        if (health == 0) {
            System.out.println(name + " has been defeated!");
        }
    }

    public void displayInfo() {
        System.out.println(name + " | HP: " + health + "/" + maxHealth +
                " | Mana: " + mana + "/" + maxMana +
                " | Status: " + (isAlive() ? "Alive" : "Dead"));
    }
}