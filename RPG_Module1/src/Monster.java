class Monster {
    String name;
    int health;
    int damage;

    public void setMonsterData(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public void displayInfo() {
        System.out.println("Monster: " + name + " | HP: " + health + " | Damage: " + damage);
    }

    public int attack() {
        return damage;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public boolean isAlive() {
        return health > 0;
    }
}