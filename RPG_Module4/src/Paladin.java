class Paladin extends Combatant implements Magical, Defensive {
    private static final int MAX_MANA = 60;
    private final int ARMOR_VALUE = 20;
    private int mana;
    private boolean defending;

    public Paladin(String name) {
        super(name, CharacterClass.PALADIN.getBaseHealth());
        this.mana = MAX_MANA;
        this.defending = false;
    }

    @Override
    public int attack() {
        return CharacterClass.PALADIN.getBaseDamage();
    }

    @Override
    public CharacterClass getCharacterClass() {
        return CharacterClass.PALADIN;
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
        if (useMana(20)) {
            int damage = (int)(attack() * element.getDamageMultiplier());
            System.out.println(name + " casts holy " + element + " spell!");
            target.takeDamage(damage);
        } else {
            System.out.println(name + " - Not enough mana!");
        }
    }

    @Override
    public void defend() {
        defending = true;
        System.out.println(name + " raises holy shield!");
    }

    @Override
    public int getArmor() {
        return ARMOR_VALUE;
    }

    @Override
    public boolean isDefending() {
        return defending;
    }

    @Override
    public void takeDamage(int damage) {
        if (defending) {
            damage = (int)(damage * 0.7);
            System.out.println(name + " reduces damage with holy shield!");
            defending = false;
        }
        super.takeDamage(damage);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Mana: " + mana + "/" + MAX_MANA + " | Armor: " + ARMOR_VALUE);
    }
}