interface Magical {
    void castSpell(Combatant target, Element element);
    int getMana();
    boolean useMana(int amount);

    default void displayMana() {
        System.out.println("Mana: " + getMana());
    }
}