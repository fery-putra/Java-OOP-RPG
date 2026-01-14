class Archer extends Combatant {
    private static final int MAX_ARROWS = 30; // STATIC FINAL
    private int arrows;

    public Archer(String name) {
        super(name, CharacterClass.ARCHER.getBaseHealth());
        this.arrows = MAX_ARROWS;
    }

    @Override
    public int attack() {
        if (arrows > 0) {
            arrows--;
            return CharacterClass.ARCHER.getBaseDamage();
        } else {
            System.out.println(name + " - Out of arrows!");
            return 5;
        }
    }

    @Override
    public CharacterClass getCharacterClass() {
        return CharacterClass.ARCHER;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Arrows: " + arrows + "/" + MAX_ARROWS);
    }
}