class Warrior extends Combatant implements Defensive {
    private final int ARMOR_VALUE = 30; // FINAL variable
    private boolean defending;

    public Warrior(String name) {
        super(name, CharacterClass.WARRIOR.getBaseHealth());
        this.defending = false;
    }

    @Override
    public int attack() {
        return CharacterClass.WARRIOR.getBaseDamage();
    }

    @Override
    public CharacterClass getCharacterClass() {
        return CharacterClass.WARRIOR;
    }

    @Override
    public void defend() {
        defending = true;
        System.out.println(name + " raises shield!");
    }

    @Override
    public int getArmor() {
        return ARMOR_VALUE; // Return final variable
    }

    @Override
    public boolean isDefending() {
        return defending;
    }

    @Override
    public void takeDamage(int damage) {
        if (defending) {
            damage = damage / 2;
            System.out.println(name + " blocks half the damage!");
            defending = false;
        }
        super.takeDamage(damage);
    }
}