interface Magical {
    void castSpell(Combatant target, Element element);
    int getMana();
    boolean useMana(int amount);

    // Since Java 8, interfaces can have default methods (concrete)
    default void displayMana() {
        System.out.println("Mana: " + getMana());
    }
}