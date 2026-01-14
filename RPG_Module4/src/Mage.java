class Mage extends Combatant implements Magical {
    private static final int MAX_MANA = 100; // STATIC FINAL constant
    private int mana;

    public Mage(String name) {
        super(name, CharacterClass.MAGE.getBaseHealth());
        this.mana = MAX_MANA;
    }

    @Override
    public int attack() {
        return CharacterClass.MAGE.getBaseDamage();
    }

    @Override
    public CharacterClass getCharacterClass() {
        return CharacterClass.MAGE;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public boolean useMana(int amount) {
        if (mana >= amount) {
            mana -= amount;
            return true;
        }
        return false;
    }

    @Override
    public void castSpell(Combatant target, Element element) {
        if (useMana(25)) {
            int damage = (int)(attack() * element.getDamageMultiplier());
            System.out.println(name + " casts " + element + " spell! " + element.getEffect());
            target.takeDamage(damage);
        } else {
            System.out.println(name + " - Not enough mana!");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        displayMana(); // Use default interface method
    }
}