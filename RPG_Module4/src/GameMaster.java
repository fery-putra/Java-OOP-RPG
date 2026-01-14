final class GameMaster {
    private static final String VERSION = "1.0";

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