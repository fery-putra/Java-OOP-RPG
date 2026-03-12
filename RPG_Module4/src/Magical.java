// ============================================================================
// MODULE 4 VERSION - Magical.java (INTERFACE)
// ============================================================================
// ⚠️ IMPORTANT: This file is specific to MODULE 4
//
// Module 4 Focus: INTERFACE defining "magical ability"
// ============================================================================

/**
 * Magical interface - MODULE 4 VERSION
 *
 * This INTERFACE demonstrates:
 * - Defining a "CAN-DO" relationship (can cast magic)
 * - Abstract methods (no implementation)
 * - Default method (with implementation)
 *
 * Classes that implement Magical:
 * - Mage (can cast spells)
 * - Paladin (can cast holy spells)
 *
 * Why INTERFACE? It defines an ABILITY, not an identity.
 * Mage IS-A Combatant (abstract class)
 * Mage CAN-DO magic (interface)
 */
interface Magical {
    // ABSTRACT METHODS - classes must implement these
    void castSpell(Combatant target, Element element);
    int getMana();
    boolean useMana(int amount);

    // DEFAULT METHOD - interface provides implementation
    // Classes can use this or override it
    default void displayMana() {
        System.out.println("Mana: " + getMana());
    }
}