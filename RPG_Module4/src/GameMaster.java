// ============================================================================
// MODULE 4 VERSION - GameMaster.java (FINAL CLASS)
// ============================================================================
// ⚠️ IMPORTANT: This file is specific to MODULE 4
//
// Module 4 Focus: FINAL CLASS (cannot be extended)
// ============================================================================

/**
 * GameMaster class - MODULE 4 VERSION (FINAL CLASS)
 *
 * This is a FINAL class - you CANNOT extend it:
 *   ✗ class MyGameMaster extends GameMaster { }  // ERROR!
 *
 * Key concepts demonstrated:
 * - FINAL CLASS (prevents inheritance)
 * - FINAL METHOD (cannot be overridden)
 * - STATIC FINAL constant (VERSION)
 *
 * Why FINAL? GameMaster controls core game logic that should
 * never be modified through inheritance. It's "locked down"
 * for security and consistency.
 */
final class GameMaster {
    private static final String VERSION = "1.0";  // STATIC FINAL constant

    // FINAL METHOD - cannot be overridden (class is final anyway)
    public final void startBattle(Combatant c1, Combatant c2) {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║      BATTLE START v" + VERSION + "       ║");
        System.out.println("╚════════════════════════════════╝");
        c1.displayInfo();
        c2.displayInfo();
        System.out.println();
    }

    public void executeTurn(Combatant attacker, Combatant defender) {
        int damage = attacker.attack();
        System.out.println(attacker.getName() + " attacks for " + damage + " damage!");
        defender.takeDamage(damage);
    }

    public void castMagicSpell(Magical caster, Combatant target, Element element) {
        System.out.println(((Combatant)caster).getName() + " prepares spell...");
        caster.castSpell(target, element);
    }

    public void activateDefense(Defensive defender) {
        defender.defend();
        System.out.println("Defense activated! Armor: " + defender.getArmor());
    }
}