class Mage extends Character {
    private int mana;
    private int maxMana;

    // Constructor with name
    public Mage(String name) {
        super(name, 80); // Call parent constructor
        this.maxMana = 100;
        this.mana = maxMana;
        System.out.println("Mage constructor called - Mana set to 100");
    }

    // Constructor Overloading - with custom mana
    public Mage(String name, int maxMana) {
        super(name, 80);
        this.maxMana = maxMana;
        this.mana = maxMana;
        System.out.println("Mage constructor called - Custom mana: " + maxMana);
    }

    // Constructor Overloading - with custom health and mana
    public Mage(String name, int maxHealth, int maxMana) {
        super(name, maxHealth);
        this.maxMana = maxMana;
        this.mana = maxMana;
        System.out.println("Mage constructor called - Custom health and mana");
    }

    public int getMana() {
        return mana;
    }

    // OVERRIDING - Use mana for powerful spell
    @Override
    public int attack() {
        if (mana >= 20) {
            mana -= 20;
            return 30; // Spell damage
        } else {
            return 5; // Weak staff attack
        }
    }

    // OVERRIDING - Different message based on mana
    @Override
    public void attack(Character target) {
        if (mana >= 20) {
            super.attack(target);
            System.out.println(getName() + " casts a powerful FIREBALL!");
        } else {
            super.attack(target);
            System.out.println(getName() + " weakly hits with staff (no mana)!");
        }
    }

    // OVERRIDING - Add mana info
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Mana: " + mana + "/" + maxMana);
    }

    // New method (not overriding)
    public void restoreMana(int amount) {
        mana = Math.min(maxMana, mana + amount);
        System.out.println(getName() + " restored " + amount + " mana! Current: " + mana);
    }
}